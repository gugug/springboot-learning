package com.gdufs.timer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.ErrorHandler;

/**
 * 引入 多线程 提高 延时任务 的 并发处理 能力
 *
 * @author gucailiang
 * @date 2018/7/4
 */
@Configuration
public class ScheduleConfiguration implements SchedulingConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleConfiguration.class);

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setTaskScheduler(taskScheduler());

    }

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(4);
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        taskScheduler.setThreadNamePrefix("schedule");
        taskScheduler.setRemoveOnCancelPolicy(true);
        taskScheduler.setErrorHandler(
                new ErrorHandler() {
                    @Override
                    public void handleError(Throwable throwable) {
                        LOGGER.error("Error occurs", throwable);
                    }
                });
        return taskScheduler;
    }

    //链接：https://juejin.im/post/5b31b9eff265da598826c200
}
