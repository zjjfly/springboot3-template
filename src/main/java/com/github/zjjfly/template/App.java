package com.github.zjjfly.template;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Zi JunJie <a href="https://github.com/zjjfly"/>github</a>
 */
@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
