package com.sharp.water;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaterDataSource {

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

    public WaterDataSource() {
        init();
    }

    public void init() {
        for (int i = 0; i < 10; i++) {
            try {
                connections[i] = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getConnection() {
        lock.lock();
        while (poolCount < 0) {
            try {
                getCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        holders[holderCount] = connections[poolCount];
        connections[poolCount] = null;
        holderCount++;
        poolCount--;
        putCondition.signal();
        lock.unlock();
    }

    public void putConnection() {
        lock.lock();
        while (poolCount == 9) {
            try {
                putCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        connections[poolCount] = holders[holderCount];
        holders[holderCount] = null;
        holderCount--;
        poolCount++;
        getCondition.signal();
        lock.unlock();

    }

    public static void main(String[] args) {
        WaterDataSource waterDataSource = new WaterDataSource();
//        Connection[] myconns = waterDataSource.connections;
        Connection[] myconns = waterDataSource.holders;
        System.out.println(myconns);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Put Thread");
                for (int i = 0; i < 20; i++) {
                    System.out.println("Put Thread Number " + i);
                    waterDataSource.putConnection();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Get Thread");
                for (int i = 0; i < 20; i++) {
                    System.out.println("Get Thread Number " + i);
                    waterDataSource.getConnection();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Put Thread 3");
                for (int i = 0; i < 20; i++) {
                    System.out.println("Put Thread 3 Number " + i);
                    waterDataSource.putConnection();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        });
        t1.start();
        t2.start();
        t3.start();
    }

}
