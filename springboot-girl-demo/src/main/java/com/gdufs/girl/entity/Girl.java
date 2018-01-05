package com.gdufs.girl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 自动创建表
 *
 * if your exection is like that <hibernate exception: org.hibernate.AnnotationException: No identifier specified for entity: com..*...>
 * You are missing a field annotated with @Id. Each @Entity needs an @Id - this is the primary key in the database.
 *
 * Created by gu on 2017/12/3.
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
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

