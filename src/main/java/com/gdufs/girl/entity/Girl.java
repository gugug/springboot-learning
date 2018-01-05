package com.gdufs.girl.entity;

import javax.persistence.Entity;

/**
 * 自动创建表
 * Created by gu on 2017/12/3.
 */
@Entity
public class Girl {
    private Integer id;


    private String cupSize;
    private Integer age;

    public Girl() {
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

