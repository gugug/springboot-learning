package com.gdufs.girl.controller;

import com.gdufs.girl.entity.GirlPorperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * value自动读取配置文件的值@Value("${cupSize}")
 * Created by gu on 2017/12/3.
 */
@RestController
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;

    @Autowired
    private GirlPorperties girlPorperties;


    @RequestMapping(value = {"hello","hi"})
    public String say(){
        return "hello spring boot !";
    }

    @RequestMapping(value = "printYml")
    public String printYml(){
        return cupSize + age + content;
    }

    @RequestMapping(value = "printEntity")
    public String printEntity(){
        return girlPorperties.getCupSize();
    }
}
