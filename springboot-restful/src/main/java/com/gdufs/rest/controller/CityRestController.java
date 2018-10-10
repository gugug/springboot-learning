package com.gdufs.rest.controller;

import com.gdufs.rest.entity.City;
import com.gdufs.rest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    /**
     * ResponseEntity中可以包含响应相关的元数据（如头部信息和状态码）以及要转换成资源表述的对象。
     * ResponseEntity允许我们指定响应的状态码，所以当无法找到Spittle的时候，我们可以返回HTTP 404错误
     * <p>
     * 路径中得到的ID用来从Repository中检索Spittle。如果找到的话，状态码设置
     * 为HttpStatus.OK（这是之前的默认值），但是如果Repository返回null的话，状态码设置
     * 为HttpStatus.NOT_FOUND，这会转换为HTTP 404。最后，会创建一个新的
     * ResponseEntity，它会把Spittle和状态码传送给客户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/city1/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> findOneCityById(@PathVariable("id") Long id) {
        City city = cityService.findCityById(id);
        HttpStatus status = city != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<City>(city, status);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
