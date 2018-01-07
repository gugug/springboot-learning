package com.gdufs.multidatasource;

import com.gdufs.multidatasource.entity.primarysource.User;
import com.gdufs.multidatasource.entity.primarysource.UserRepository;
import com.gdufs.multidatasource.entity.secondarysource.City;
import com.gdufs.multidatasource.entity.secondarysource.CityRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by gu on 2018/1/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DataSourceConfigTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CityRepository cityRepository;

    @Test
    public void test() throws Exception {

        userRepository.save(new User("aaa", 10));
        userRepository.save(new User("bbb", 20));
        userRepository.save(new User("ccc", 30));
        userRepository.save(new User("ddd", 40));
        userRepository.save(new User("eee", 50));

        Assert.assertEquals(5, userRepository.findAll().size());

        cityRepository.save(new City("o1", 1L));
        cityRepository.save(new City("o2", 2L));
        cityRepository.save(new City("o3", 3L));

        Assert.assertEquals(3, cityRepository.findAll().size());

    }

}