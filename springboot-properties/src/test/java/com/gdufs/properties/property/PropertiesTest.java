package com.gdufs.properties.property;

import com.gdufs.properties.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * application.properties 配置中文值的时候，读取出来的属性值会出现乱码问题。
 * 但是 application.yml 不会出现乱码问题。原因是，Spring Boot 是以 iso-8859 的编码方式读取 application.properties 配置文件。
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PropertiesTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesTest.class);



    @Autowired
    private HomeProperties homeProperties;

    @Test
    public void getHomeProperties() {
        LOGGER.info("\n\n" + homeProperties.toString() + "\n");
    }



}