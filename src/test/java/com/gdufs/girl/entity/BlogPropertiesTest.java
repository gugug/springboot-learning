package com.gdufs.girl.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BlogPropertiesTest {
    @Autowired
    BlogProperties blogProperties;
    @Test
    public void getGirlProperties() throws Exception {
        Assert.assertEquals(blogProperties.getName(), "learning");
    }
}