package com.gdufs.timer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author gucailiang
 * @date 2018/7/4
 */
@Component
public class SprnigBootSchduleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SprnigBootSchduleService.class);
    private AtomicLong counter = new AtomicLong();


    /**
     * 上一次 开始执行时间点 之后 10 秒再执行。
     *
     * @throws Exception
     */
    @Scheduled(fixedRate = 10 * 1000L)
    public void scheduleAtFixedRate() throws Exception {
        long count = counter.incrementAndGet();
        LOGGER.info("Schedule executor {} times at fixed rate", count);
    }


    /**
     * 上一次 执行完毕时间点 之后 10 秒再执行。
     *
     * @throws Exception
     */
    @Scheduled(fixedDelay = 10 * 1000L)
    public void scheduleWithFixedDelay() throws Exception {
        try {
            TimeUnit.MILLISECONDS.sleep(10 * 1000L);
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted exception", e);
        }
        long count = counter.incrementAndGet();
        LOGGER.info("Schedule executor {} times with fixed delay", count);
    }

    /**
     * 第一次延迟 2 秒后执行，之后按 fixedRate 的规则每 10 秒执行一次。
     *
     * @throws Exception
     */
    @Scheduled(initialDelay = 2000L, fixedDelay = 10 * 1000L)
    public void scheduleWithinitialDelayAndFixedDelay() throws Exception {
        try {
            TimeUnit.MILLISECONDS.sleep(10 * 1000L);
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted exception", e);
        }
        long count = counter.incrementAndGet();
        LOGGER.info("Schedule executor {} times with fixed delay", count);
    }

    /**
     * 根据 cron 表达式定义，每隔 10 秒执行一次。
     *
     * @throws Exception
     */
    @Scheduled(cron = "0/10 * * * * *")
    public void scheduleWithCronExpression() throws Exception {
        long count = counter.incrementAndGet();
        LOGGER.info("Schedule executor {} times with ", count);
    }


}
