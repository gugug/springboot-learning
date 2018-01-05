package com.gdufs.swagger2.controller;

import com.gdufs.swagger2.entity.City;
import com.gdufs.swagger2.service.CityService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;


    @ApiOperation(value="获取城市详细信息", notes="根据url的id来获取城市详细信息")
    @ApiImplicitParam(name = "id", value = "城市ID", required = true, dataType = "Long")
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @ApiOperation(value="获取城市列表", notes="无")
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @ApiOperation(value="创建城市", notes="根据City对象创建城市")
    @ApiImplicitParam(name = "city", value = "城市详细实体city", required = true, dataType = "City")
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }


    @ApiOperation(value="更新城市详细信息", notes="根据url的id来指定更新对象，并根据传过来的city信息来更新城市详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "城市ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "城市详细实体city", required = true, dataType = "User")
    })
    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @ApiOperation(value="删除城市", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "城市ID", required = true, dataType = "Long")
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
