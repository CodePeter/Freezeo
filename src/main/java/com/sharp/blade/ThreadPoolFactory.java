package com.sharp.blade;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolFactory {

    public static final Logger logger = LoggerFactory.getLogger(ThreadPoolFactory.class);

    private static ThreadPoolExecutor executor;
    public static final int QUEUE_SIZE = 10000;
    public static final long DEFAULT_WAIT_MILLISECOND = 3000L;

    static {
        try {
            int processors = Runtime.getRuntime().availableProcessors();
            ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                    .setNameFormat("xuexi-pool-%d").build();
            executor = new ThreadPoolExecutor(processors * 2,
                    processors * 3,
                    200,
                    TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<Runnable>(QUEUE_SIZE),namedThreadFactory
            );
            executor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            logger.error("线程初始化失败,失败原因:{}", e.getMessage());
        }
    }

    public static void execute (Runnable command) throws Exception{
        try {
            executor.execute(command);
        } catch (Exception e) {
            logger.error("新增线程失败, 任务数:{}, 最大线程数:{}, 最大设置线程数:{}, 失败原因:{}",
                    executor.getTaskCount(),
                    executor.getLargestPoolSize(),
                    executor.getMaximumPoolSize(),
                    e.getMessage());
            throw e;
        }
    }

    public static void defaultWaitMillisecond (Runnable command) throws Exception {
        execute(command, DEFAULT_WAIT_MILLISECOND);
    }

    public static void execute (Runnable command, long waitMils) throws Exception {
        if (executor.getQueue().size() == QUEUE_SIZE) {
            Thread.sleep(waitMils);
        }
        executor.execute(command);
    }

}
