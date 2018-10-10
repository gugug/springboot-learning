package com.gdufs.rest.controller;

import com.gdufs.rest.entity.City;
import com.gdufs.rest.entity.Error;
import com.gdufs.rest.exception.CityNotFoundException;
import com.gdufs.rest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author gucailiang
 * @date 2018/10/10
 */
@Controller
@RequestMapping(value = "city")
public class CityController {
    @Autowired
    private CityService cityService;


    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    public @ResponseBody
    City findOneCity(@PathVariable("id") Long id) {
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
     * <p>
     * ResponseEntity还包含了@ResponseBody的语义，因此负载部分将会渲染
     * 到响应体中，就像之前在方法上使用@ResponseBody注解一样。如果返回ResponseEntity的
     * 话，那就没有必要在方法上使用@ResponseBody注解了。
     * </p>
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api2/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> findOneCity2(@PathVariable("id") Long id) {
        City city = cityService.findCityById(id);
        HttpStatus status = city != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<City>(city, status);
    }

    /**
     * 返回响应体包含错误信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api3/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOneCity3(@PathVariable("id") Long id) {
        City city = cityService.findCityById(id);
        if (null == city) {
            Error error = new Error(4, "city id [" + id + "] not found");
            return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }

    /**
     * 使用异常处理器处理异常
     * 这个版本的spittleById()方法确实干净了很多。除了对返回值进行null检查，它完全关注于成功的场景，也就是能够找到请求的Spittle。同时，在返回类型中，我们能移除掉奇怪的泛型了。
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api4/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> findOneCity4(@PathVariable("id") Long id) {
        City city = cityService.findCityById(id);
        if (null == city) {
            throw new CityNotFoundException(id);
        }
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }

    /**
     * 最干净的版本：ResponseEntity已经不需要了，只需要Responbody
     * 现在我们已经知道spittleById()将会返回Spittle并且HTTP状态码始终会是200（OK），那么就可以不再使用ResponseEntity，而是将其替换为@ResponseBody
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api5/{id}", method = RequestMethod.GET)
    public @ResponseBody City findOneCity5(@PathVariable("id") Long id) {
        City city = cityService.findCityById(id);
        if (null == city) {
            throw new CityNotFoundException(id);
        }
        return city;
    }

//    /**
//     * 对应CityNotFoundException的错误处理器
//     * <p>
//     *
//     * @ExceptionHandler注解能够用到控制器方法中，用来处理特定的异常。这里，它表明如果在控制器的任意处理方法中抛出CityNotFoundException异常，就会调用cityNotFound()方法来处理异常。 </p>
//     */
//    @ExceptionHandler(CityNotFoundException.class)
//    public ResponseEntity<Error> cityNotFound(CityNotFoundException e) {
//        long cityId = e.getCityId();
//        Error error = new Error(4, "city id [" + cityId + "] not found");
//        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
//    }

    /**
     * 鉴于错误处理器的方法会始终返回Error，并且HTTP状态码为404（Not Found），那么现在我们可以对spittleNotFound()方法进行类似的清理：
     * <p>
     * 因为spittleNotFound()方法始终会返回Error，所以使用ResponseEntity的唯一原
     * 因就是能够设置状态码。但是通过为spittleNotFound()方法添
     * 加@ResponseStatus(HttpStatus.NOT_FOUND)注解，我们可以达到相同的效果，而且
     * 可以不再使用ResponseEntity了。
     * </p>
     */
    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error cityNotFound2(CityNotFoundException e) {
        long cityId = e.getCityId();
        return new Error(4, "city id [" + cityId + "] not found");
    }

}
