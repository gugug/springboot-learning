package com.gdufs.mybatis.controller;

import com.gdufs.mybatis.dao.CityDao;
import com.gdufs.mybatis.entity.City;
import com.gdufs.mybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class CityRestController {

    //注解的方式整合mybatis
    @Autowired
    private CityService cityService;

    //xml的方式整合mybatis
    @Autowired
    private CityDao cityDao;

    @RequestMapping(value = "/mapper-api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/xml-api/city/{id}", method = RequestMethod.GET)
    public City findCityById(@PathVariable("id") Long id) {
        return cityDao.findById(id);
    }


}
