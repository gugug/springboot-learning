package com.gdufs.mybatis.xml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 *
 * @MapperScan("com.gdufs.com.gdufs.rest.dao")
 * 配置mapper扫描的包 不然会报异常 dao找不到
 * 用这个注解可以注册 Mybatis mapper 接口类。
 * <p>
 */
@SpringBootApplication
@MapperScan("com.gdufs.mybatis.xml.dao")
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        SpringApplication.run(Application.class, args);
    }

}
