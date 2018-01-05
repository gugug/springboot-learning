package com.gdufs.girl.dao;

import com.gdufs.girl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * jpa组件
 * Created by gu on 2017/12/3.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄查询
    public List<Girl> findByAge(Integer age);
}