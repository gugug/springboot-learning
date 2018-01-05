package com.gdufs.girl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot中Bean注解扫描默认是扫描Application类所在的包及其子包
 */
@SpringBootApplication
@ComponentScan()
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
