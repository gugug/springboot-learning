package com.gdufs.girl.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GirlPorpertiesTest {
    @Autowired
    private GirlPorperties girlPorperties;

    @Test
    public void getGirlProperties() throws Exception {
        Assert.assertEquals(girlPorperties.getAge().toString(), "18");
        Assert.assertEquals(girlPorperties.getCupSize(), "B");
        System.out.println("random测试： "+girlPorperties.getNumber());
    }
}