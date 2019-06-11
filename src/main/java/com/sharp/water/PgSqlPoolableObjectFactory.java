package com.sharp.water;


import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Deque;

public class PgSqlPoolableObjectFactory implements PooledObjectFactory<Connection> {

    private String url = "jdbc:postgresql://192.168.5.73:5432/sinan?prepareThreshold=0";
    private String username = "postgres";
    private String password = "postgres";

    @Override
    public PooledObject<Connection> makeObject() throws Exception {
        System.out.println("Make Connection!");
        return new DefaultPooledObject<>(DriverManager.getConnection(url, username, password));
    }

    @Override
    public void destroyObject(PooledObject<Connection> p) throws Exception {
        if (p.getObject() instanceof Connection) {
            if (p.getObject() != null) {
                try {
                    p.getObject().close();
                    System.out.println("Close Connection!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean validateObject(PooledObject p) {
        return false;
    }

    @Override
    public void activateObject(PooledObject p) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject p) throws Exception {

    }

    public static void main(String[] args) {
        PgSqlPoolableObjectFactory factory = new PgSqlPoolableObjectFactory();
        GenericObjectPool<Connection> pool = new GenericObjectPool<>(factory);
        pool.setMaxTotal(20); // 能从池中借出的对象的最大数目
        pool.setMaxIdle(20); // 池中可以空闲对象的最大数目
        pool.setMaxWaitMillis(100); // 对象池空时调用borrowObject方法，最多等待多少毫秒
        pool.setTimeBetweenEvictionRunsMillis(600000);// 间隔每过多少毫秒进行一次后台对象清理的行动
        pool.setNumTestsPerEvictionRun(-1);// －1表示清理时检查所有线程
        pool.setMinEvictableIdleTimeMillis(3000);// 设定在进行后台对象清理时，休眠时间超过了3000毫秒的对象为过期
        for (int i = 0; i < 10; i++) {
            try {
                Connection conn = pool.borrowObject();

                System.out.println(conn.getCatalog());
                System.out.println(conn.getSchema());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(60000); // 休息一会儿，再使用线程池
        } catch (InterruptedException ex1) {
        }
        System.out.println("------------------------------");
        System.out.println(pool.getNumIdle());
        System.out.println(pool.getNumActive());
        System.out.println(pool.getNumWaiters());
//        for (int i = 0; i < 10; i++) {
//            try {
//                SimpleThread simpleThread = (SimpleThread) pool.borrowObject();
//                simpleThread.setPool(pool);
//                simpleThread.setIsRunning(true);
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
//
//        }
    }
}
