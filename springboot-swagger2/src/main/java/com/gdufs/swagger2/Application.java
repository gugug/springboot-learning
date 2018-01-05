package com.gdufs.swagger2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 * <p>
 */
@SpringBootApplication
@MapperScan("com.gdufs.swagger2.dao")
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        SpringApplication.run(Application.class, args);
    }

}
