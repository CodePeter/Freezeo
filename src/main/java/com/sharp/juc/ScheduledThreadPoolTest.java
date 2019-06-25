package com.sharp.juc;

import java.util.concurrent.*;

public class ScheduledThreadPoolTest {
    static int count = 0;

    public static void main(String[] args) {
//        ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(5);
//        Future future = schedule.scheduleAtFixedRate(() -> {
//            count++;
//            System.out.println(Thread.currentThread().getId());
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },0,1,TimeUnit.SECONDS);
//        try {
//            future.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(1);
        Task task = new Task();
        ScheduledFuture<Integer> future = schedule.schedule(task, 1, TimeUnit.SECONDS);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
//        Thread thread = new Thread(futureTask);
//        thread.start();
        Job job = new Job();
        ScheduledFuture jobFuture = schedule.schedule(job, 1, TimeUnit.SECONDS);
        try {
            System.out.println(jobFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
