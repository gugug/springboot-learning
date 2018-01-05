package com.gdufs.girl.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

/**
 * 通过@Value("${属性名}")注解来加载对应的配置属性
 * Created by gucailiang on 2018/1/5.
 */
@Component
public class BlogProperties {

    @Value("${com.gdufs.blog.name}")
    private String name;

    @Value("${com.gdufs.blog.title}")
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
