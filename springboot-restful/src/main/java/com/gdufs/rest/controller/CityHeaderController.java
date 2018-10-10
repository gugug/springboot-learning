package com.gdufs.rest.controller;

import com.gdufs.rest.entity.City;
import com.gdufs.rest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 本部分主要演示了在响应中设置头部信息
 *
 * @author gucailiang
 * @date 2018/10/10
 */
@RestController
@RequestMapping(value = "city")
public class CityHeaderController {

    @Autowired
    private CityService cityService;


    /**
     * @param city
     * @return
     */
    @RequestMapping(value = "/api/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Long saveCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    /**
     * 当创建新资源的时候，将资源的URL放在响应的Location头部信息中，并返回给客户端是一
     * 种很好的方式。因此，我们需要有一种方式来填充响应头部信息，此时我们的老朋友
     * ResponseEntity就能提供帮助了。
     * <p>
     * 注意：mapper接口返回值依然是成功插入的记录数，但不同的是主键值已经赋值到领域模型实体的id中了。
     */
    @RequestMapping(value = "/api2/add", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ResponseEntity<City> saveCity2(@RequestBody City city) {
        HttpHeaders httpHeaders = new HttpHeaders();
        Long id = cityService.saveCity(city);
        URI locationUrl = URI.create("localhost:8081/city/api5/" + city.getId());
        httpHeaders.setLocation(locationUrl);
        return new ResponseEntity<City>(city, httpHeaders, HttpStatus.CREATED);
    }

    /**
     * 原本简单的saveSpittle()方法瞬间变得臃肿了。但是，更值得关注的是，它使用硬编码值的方式来构建Location头部信息。
     * URL中“localhost”以及“8080”这两个部分尤其需要注意，因为如果我们将应用部署到其他地方，而不是在本地运行的话，它们就不适用了
     * <p>
     * 其实没有必要手动构建URL，Spring提供了UriComponentsBuilder，可以给我们一些帮助。它是一个构建类，通过逐步指定URL中的各种组成部分（如host、端口、路径以及查询），
     * 我们能够使用它来构建UriComponents实例。借助UriComponentsBuilder所构建的UriComponents对象，我们就能获得适合设置给Location头部信息的URI。
     * <p>
     * 为了使用UriComponentsBuilder，我们需要做的就是在处理器方法中将其作为一个参数
     */
    @RequestMapping(value = "/api3/add", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    ResponseEntity<City> saveCity3(@RequestBody City city, UriComponentsBuilder uriComponentsBuilder) {
        HttpHeaders httpHeaders = new HttpHeaders();
        Long id = cityService.saveCity(city);
        URI locationUrl = uriComponentsBuilder.path("city/api5/").path(String.valueOf(city.getId())).build().toUri();
        httpHeaders.setLocation(locationUrl);
        return new ResponseEntity<City>(city, httpHeaders, HttpStatus.CREATED);
    }
}
