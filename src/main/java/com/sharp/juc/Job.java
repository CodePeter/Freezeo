package com.sharp.juc;

import java.util.concurrent.Callable;

public class Job implements Runnable {
    @Override
    public void run() {
        System.out.println("Job:子线程在进行计算");
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        System.out.println(sum);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
