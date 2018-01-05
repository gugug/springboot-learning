package com.gdufs.girl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot中Bean注解扫描默认是扫描Application类所在的包及其子包
 * 右键Run运行这个Application类
 * Tomcat started on port(s): your port (http)
 * Started Application in * seconds (JVM running for 7.398)
 */
@SpringBootApplication
@ComponentScan()
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
