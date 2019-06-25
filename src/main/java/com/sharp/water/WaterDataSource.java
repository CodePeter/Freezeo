package com.sharp.water;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class WaterDataSource implements DataSource {

    private int poolCount = 9;
    private int holderCount = 0;
    private Connection[] connections = new Connection[10];
    private Connection[] holders = new Connection[10];
    private String url = "jdbc:postgresql://192.168.5.73:5432/sinan?prepareThreshold=0";
    private String username = "postgres";
    private String password = "postgres";
    private Lock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition getCondition = lock.newCondition();
    private ConnectionHolder[] connectionHolders = new ConnectionHolder[10];
    private ConnectionHolder activeHolder;
//    private Connection activeConnection;

    public WaterDataSource() {
        init();
    }

    public void init() {
        for (int i = 0; i < 10; i++) {
            try {
//                connectionHolders[i] = new ConnectionHolder(DriverManager.getConnection(url, username, password));
                connections[i] = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Connection getConnection(String username, String password) {
        return null;
    }

    @Override
    public Connection getConnection() {
        lock.lock();
        while (poolCount < 0) {
            try {
                getCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection activeConnection = connections[poolCount];
        connectionHolders[poolCount] = null;
        poolCount--;
        putCondition.signal();
        lock.unlock();
        return activeConnection;
    }


    public void putConnection(Connection connection) {
        lock.lock();
        while (poolCount > 9) {
            try {
                putCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        poolCount++;
        connections[poolCount] = connection;
        getCondition.signal();
        lock.unlock();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, SQLException {
        WaterDataSource waterDataSource = new WaterDataSource();
        waterDataSource.init();
        GetConnectionTask getConnectionTask = new GetConnectionTask(waterDataSource);
//        GetConnectionJob getConnectionJob = new GetConnectionJob(waterDataSource);
        FutureTask<Connection> connectionFuture = new FutureTask<>(getConnectionTask);
        Thread t = new Thread(connectionFuture);
        t.start();
        Connection conn = connectionFuture.get();
        System.out.println("Pool Size: " + waterDataSource.poolCount);
        System.out.println("Connection Info: " + conn.getSchema() + " " + conn.getCatalog());
        waterDataSource.putConnection(conn);
        System.out.println("Pool Size: " + waterDataSource.poolCount);


    }

}
