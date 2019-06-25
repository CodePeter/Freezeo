package com.sharp.juc;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,1000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        for (int i=0; i<30; i++) {
            final int index = i;
            executor.execute(() -> {
                System.out.println("线程序号："+index);
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getState().name());
            });
            System.out.println("总任务数："+executor.getTaskCount());
            System.out.println("完成任务数："+executor.getCompletedTaskCount());
            System.out.println("活跃任务数："+executor.getActiveCount());
            System.out.println("最大线程数："+executor.getLargestPoolSize());
            System.out.println("线程数："+executor.getPoolSize());
        }

        executor.shutdown();

    }
}
