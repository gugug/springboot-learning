package com.gdufs.timer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author gucailiang
 * @date 2018/7/4
 */
public class TimerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimerService.class);
    private AtomicLong counter = new AtomicLong();

    /**
     * 在 TimerTask 中累加 执行次数.
     * Timer 的内部只有 一个线程，如果有 多个任务 的话就会 顺序执行，这样任务的 延迟时间 和 循环时间 就会出现问题。
     * 能够发现 TimerTask 配置的任务每隔 10s 被执行了一次，执行线程默认都是 Timer-0 这个线程。
     */
    private void schedule() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                long count = counter.incrementAndGet();
                LOGGER.info("Schedule timerTask {} times", count);
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 1000L, 10 * 1000L);
    }

    /**
     * 每隔 20 秒的时间间隔，就会有 4 个定时任务同时执行。因为在任务线程池初始化时，我们同时向线程池提交了 4 个任务，这 四个任务 会完全利用线程池中的 4 个线程进行任务执行
     */
    private void scheduleWithFixedDelay() {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < 4; i++) {
            scheduledExecutor.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10 * 1000L);
                    } catch (InterruptedException e) {
                        LOGGER.error("Interrupted exception", e);
                    }
                    long count = counter.incrementAndGet();
                    LOGGER.info("Schedule executor {} times with fixed delay", count);
                }
            }, 2000L, 10 * 1000L, TimeUnit.MILLISECONDS);
        }
        LOGGER.info("Start to schedule");
    }

    /**
     * 并在上一次 开始执行时间点 之后 10 秒再执行下一次任务。
     */
    private void scheduleAtFixedRate() {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < 4; i++) {
            scheduledExecutor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    long count = counter.incrementAndGet();
                    LOGGER.info("Schedule executor {} times at fixed rate", count);
                }
            }, 2000L, 10 * 1000L, TimeUnit.MILLISECONDS);
        }
        LOGGER.info("Start to schedule");
    }



    public static void main(String[] args) {
        TimerService timerService = new TimerService();
//        timerService.schedule();
//        timerService.scheduleWithFixedDelay();
        timerService.scheduleAtFixedRate();
    }

}
