package com.gdufs.jpa.dao;

import com.gdufs.jpa.entity.City;
import com.gdufs.jpa.service.CityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CityRepositoryTest {

    @Autowired
    private CityService cityService;

    @Test
    public void test() throws Exception {

        // 创建10条记录
        cityService.insert(new City("AAA", 10l));
        cityService.insert(new City("BBB", 20l));
        cityService.insert(new City("CCC", 30l));
        cityService.insert(new City("DDD", 40l));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(4, cityService.findAll().size());

        // findByCityName, 查询姓名为FFF的City
        Assert.assertEquals(10l, cityService.findByCityName("AAA").get(0).getProvinceId().longValue());


        // 测试删除姓名为AAA的City
        cityService.deleteById(cityService.findByCityName("AAA").get(0).getId());

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(3, cityService.findAll().size());

    }


}