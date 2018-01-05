package com.gdufs.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * application.properties 配置中文值的时候，读取出来的属性值会出现乱码问题。
 * 但是 application.yml 不会出现乱码问题。原因是，Spring Boot 是以 iso-8859 的编码方式读取 application.properties 配置文件。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PropertiesTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesTest.class);

    @Autowired
    private UserProperties userProperties;

    @Autowired
    private HomeProperties homeProperties;

    @Test
    public void getHomeProperties() {
        LOGGER.info("\n\n" + homeProperties.toString() + "\n");
    }

    @Test
    public void randomTestUser() {
        LOGGER.info("\n\n" + userProperties.toString() + "\n");
    }

}