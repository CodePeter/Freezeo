package com.sharp.water;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class PgSqlConnectionManager implements ConnectionManager {

    //    private List<Connection> connections = new ArrayList<>();
//    private Queue<Connection> conns = new ConcurrentLinkedQueue();
    private ArrayBlockingQueue<Connection> conns = new ArrayBlockingQueue(10);
    private String url = "jdbc:postgresql://192.168.5.73:5432/sinan?prepareThreshold=0";
    private String username = "postgres";
    private String password = "postgres";
    private boolean ready = false;

    public PgSqlConnectionManager() throws SQLException, InterruptedException {
        init();
    }

    private void init() throws SQLException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            Connection conn = DriverManager.getConnection(url, username, password);
//            conns.add(conn);
            conns.put(conn);
        }
        System.out.println("Initialization Finished!");
    }

    public void destroy() {
//        if (conns.size() == 10) {
            for(Connection conn : conns) {
                if(conn != null) {
                    try {
                        conn.close();
                        System.out.println("Close Connection!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
//        }

    }

    public Connection getConnection() {
        if (conns.peek() != null) {
            System.out.println("Get A Connection!");
            return conns.poll();
        }
        System.out.println("Get A Null!");
        return null;
    }

    public void releaseConnection(Connection conn) {
        if (conn != null) {
            System.out.println("Release A Connection!");
            conns.offer(conn);
        }
        System.out.println("Release A Null!");
    }

//    public synchronized Connection getConnection() {
//        while(connections.peek()==null) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        connections.get()
//    }

    public static void main(String[] args) throws SQLException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10));
        PgSqlConnectionManager manager = new PgSqlConnectionManager();
        manager.init();
        for(int i=0;i<15;i++){
            Future<Connection> future = executor.submit(new Callable<Connection>() {
                @Override
                public Connection call() throws Exception {
                    return manager.getConnection();
                }
            });
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        manager.releaseConnection(future.get());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (ExecutionException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
//        manager.destroy();
    }

}
