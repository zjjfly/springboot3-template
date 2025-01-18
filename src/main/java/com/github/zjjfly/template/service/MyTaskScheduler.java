package com.github.zjjfly.template.service;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
@Service
@Slf4j
public class MyTaskScheduler {

    @Scheduled(cron = "0 * * * * ?")
    @SchedulerLock(name = "TaskScheduler_someTask", lockAtLeastFor = "PT60s",
            lockAtMostFor = "PT10M")
    public void someTask() throws InterruptedException {
        log.info("task running...");
        Thread.sleep(1000L);
        log.info("task finished...");
    }
}
