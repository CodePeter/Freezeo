package com.sharp.juc;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicTest {
    public static void main(String[] args) {
        // 新建AtomicLong对象
        AtomicLong mAtoLong = new AtomicLong(1L);

        System.out.printf("%20s : %20d\n", "get()", mAtoLong.get());
        System.out.printf("%20s : %20d\n", "intValue()", mAtoLong.intValue());
        System.out.printf("%20s : %20d\n", "longValue()", mAtoLong.longValue());
        System.out.printf("%20s : %s\n", "doubleValue()", mAtoLong.doubleValue());
        System.out.printf("%20s : %s\n", "floatValue()", mAtoLong.floatValue());

        System.out.printf("%20s : %20d\n", "getAndDecrement()", mAtoLong.getAndDecrement());
        System.out.printf("%20s : %20d\n", "decrementAndGet()", mAtoLong.decrementAndGet());
        System.out.printf("%20s : %20d\n", "getAndIncrement()", mAtoLong.getAndIncrement());
        System.out.printf("%20s : %20d\n", "incrementAndGet()", mAtoLong.incrementAndGet());

        System.out.printf("%20s : %20d\n", "addAndGet(5)", mAtoLong.addAndGet(5L));
        System.out.printf("%20s : %20d\n", "getAndAdd(5)", mAtoLong.getAndAdd(5L));

        System.out.printf("\n%20s : %20d\n", "get()", mAtoLong.get());

        System.out.printf("%20s : %s\n", "compareAndSet()", mAtoLong.compareAndSet(10L, 0L));
        System.out.printf("%20s : %20d\n", "get()", mAtoLong.get());
        // 新建AtomicLong数组对象
        AtomicLong[] atomicLongs = new AtomicLong[]{
                new AtomicLong(10L),new AtomicLong(20L),new AtomicLong(30L),new AtomicLong(40L),new AtomicLong(50L)};
        atomicLongs[0].set(100);
        for (int i = 0, len = atomicLongs.length; i < len; i++)
            System.out.printf("get(%d) : %s\n", i, atomicLongs[i].get());
        System.out.printf("%20s : %s\n", "getAndDecrement(0)", atomicLongs[0].getAndDecrement());
        System.out.printf("%20s : %s\n", "decrementAndGet(1)", atomicLongs[1].decrementAndGet());
        System.out.printf("%20s : %s\n", "getAndIncrement(2)", atomicLongs[2].getAndIncrement());
        System.out.printf("%20s : %s\n", "incrementAndGet(3)", atomicLongs[3].incrementAndGet());

        System.out.printf("%20s : %s\n", "addAndGet(100)", atomicLongs[0].addAndGet(100));
        System.out.printf("%20s : %s\n", "getAndAdd(100)", atomicLongs[1].getAndAdd(100));

        System.out.printf("%20s : %s\n", "compareAndSet()", atomicLongs[2].compareAndSet(31,1000));
        System.out.printf("%20s : %s\n", "get(0)", atomicLongs[0].get());
        System.out.printf("%20s : %s\n", "get(1)", atomicLongs[1].get());
        System.out.printf("%20s : %s\n", "get(2)", atomicLongs[2].get());
        System.out.printf("%20s : %s\n", "get(3)", atomicLongs[3].get());
        System.out.printf("%20s : %s\n", "get(4)", atomicLongs[4].get());

        // 新建AtomicLongArray对象
        long[] arrLong = new long[]{10, 20, 30, 40, 50};
        AtomicLongArray ala = new AtomicLongArray(arrLong);
        ala.set(0, 100);
        for (int i = 0, len = ala.length(); i < len; i++)
            System.out.printf("get(%d) : %s\n", i, ala.get(i));

        System.out.printf("%20s : %s\n", "getAndDecrement(0)", ala.getAndDecrement(0));
        System.out.printf("%20s : %s\n", "decrementAndGet(1)", ala.decrementAndGet(1));
        System.out.printf("%20s : %s\n", "getAndIncrement(2)", ala.getAndIncrement(2));
        System.out.printf("%20s : %s\n", "incrementAndGet(3)", ala.incrementAndGet(3));

        System.out.printf("%20s : %s\n", "addAndGet(100)", ala.addAndGet(0, 100));
        System.out.printf("%20s : %s\n", "getAndAdd(100)", ala.getAndAdd(1, 100));

        System.out.printf("%20s : %s\n", "compareAndSet()", ala.compareAndSet(2, 31, 1000));
        System.out.printf("%20s : %s\n", "get(0)", ala.get(0));
        System.out.printf("%20s : %s\n", "get(1)", ala.get(1));
        System.out.printf("%20s : %s\n", "get(2)", ala.get(2));
        System.out.printf("%20s : %s\n", "get(3)", ala.get(3));
        System.out.printf("%20s : %s\n", "get(4)", ala.get(4));
    }
}
