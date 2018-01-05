package com.gdufs.jpa.web.controller;

import com.gdufs.jpa.entity.City;
import com.gdufs.jpa.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findById(id);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAll();
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public City createCity(@RequestBody City city) {
        return cityService.insert(city);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public City modifyCity(@RequestBody City city) {
        return cityService.update(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteById(id);
    }
}
