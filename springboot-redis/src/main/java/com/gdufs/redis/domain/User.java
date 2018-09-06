package com.gdufs.redis.domain;

import java.io.Serializable;

/**
 * Created by gucailiang on 2018/1/9.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

    private Integer code;
    private System name;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", code=" + code +
                ", name=" + name +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public System getName() {
        return name;
    }

    public void setName(System name) {
        this.name = name;
    }

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
