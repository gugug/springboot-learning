package com.gdufs.redis.controller;

import com.gdufs.redis.domain.User;
import com.gdufs.redis.domain.UserReq;
import com.gdufs.redis.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>用户控制层 简单演示增删改查及分页</pre>
 *
 * @author gucailiang
 * @date 2018/9/6
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户API")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("add")
    @ApiOperation(value = "用户新增")
    public Map<String, String> addUser(@Valid UserReq userReq) {
        User user = new User();
        user.setCode(userReq.getCode());
        user.setName(userReq.getName());
        userService.insert(user);
        Map<String, String> result = new HashMap<String, String>();
        result.put("respCode", "01");
        result.put("respMsg", "新增成功");
        return result;
    }

    /**
     * 更新时 直接删除缓存 以保证下次获取时先从数据库中获取最新数据
     *
     * @param userReq
     * @return
     * @CacheEvict：从缓存中移除相应数据。
     */
    @PostMapping("update")
    @ApiOperation(value = "用户修改")
    @CacheEvict(value = "RKOO", key = "#userReq.id")
    public Map<String, String> updateUser(@Valid UserReq userReq) {

        if (userReq.getId() == null || "".equals(userReq.getId())) {
            throw new IllegalArgumentException("更新时ID不能为空");
        }
        User user = new User();
        user.setCode(userReq.getCode());
        user.setName(userReq.getName());
        Map<String, String> result = new HashMap<String, String>();
        result.put("respCode", "01");
        result.put("respMsg", "更新成功");
        return result;
    }

    /**
     * @param id
     * @return
     * @Cacheable：标记在一个方法上，也可以标记在一个类上。主要是缓存标注对象的返回结果，标注在方法上缓存该方法的返回值，标注在类上，缓存该类所有的方法返回值。
     */
    @GetMapping("/get/{id}")
    @ApiOperation(value = "用户查询(ID)")
    @ApiImplicitParam(name = "id", value = "查询ID", required = true)
    @Cacheable(value = "RKOO", key = "#id")
    public Map<String, Object> getUser(@PathVariable("id") String id) {
        User user = userService.get(Integer.parseInt(id));
        if (user == null) {
            throw new IllegalArgumentException("用户ID：" + id + "，未找到");
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("respCode", "01");
        result.put("respMsg", "成功");
        result.put("id", id);
        System.out.println(result);
        return result;
    }

    @GetMapping("/get1/{id}")
    @ApiOperation(value = "用户查询(ID)")
    @ApiImplicitParam(name = "id", value = "查询ID", required = true)
    @Cacheable(value = "RKOO", key = "#id")
    public User getUser1(@PathVariable("id") String id) {
        User nkoo = new User("NKOO", Integer.parseInt(id));
        System.out.println(nkoo);
        return nkoo;
    }


}