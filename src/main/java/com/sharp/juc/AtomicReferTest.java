package com.sharp.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicReferTest {

    public void atomicIntegerIncrement(AtomicInteger count) {
        count.getAndIncrement();
    }

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        AtomicReferTest test = new AtomicReferTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (;;) {
            if (count.get() == 10) {
                System.out.println("Out Side: "+count.get());
                executorService.shutdownNow();
                break;
            }
            executorService.submit(() -> {
//                test.atomicIntegerIncrement(count);
                System.out.println(count.getAndIncrement());
            });

        }
    }
}
