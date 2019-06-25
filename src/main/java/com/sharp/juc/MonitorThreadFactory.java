package com.sharp.juc;

import java.util.concurrent.ThreadFactory;

public class MonitorThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
//        Thread t = new Thread(r, "");
        return new Thread(r);
    }
}
