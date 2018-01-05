package com.gdufs.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Spring Boot 应用启动类
 * @MapperScan("com.gdufs.com.gdufs.rest.dao")
 * 配置mapper扫描的包 不然会报异常 dao找不到
 * <p>
 */
@SpringBootApplication
@MapperScan("com.gdufs.rest.dao")
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        SpringApplication.run(Application.class, args);
    }

}
