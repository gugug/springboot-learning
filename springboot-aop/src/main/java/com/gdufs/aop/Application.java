package com.gdufs.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * # AOP
 * spring.aop.auto=true # Add @EnableAspectJAutoProxy.
 * spring.aop.proxy-target-class=false # Whether subclass-based (CGLIB) proxies are to be created (true) as
 * opposed to standard Java interface-based proxies (false).
 * 而当我们需要使用CGLIB来实现AOP的时候，需要配置spring.aop.proxy-target-class=true，不然默认使用的是标准Java的实现。
 * <p>
 * //@EnableAspectJAutoProxy
 * <p>
 * Created by gu on 2018/1/7.
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
