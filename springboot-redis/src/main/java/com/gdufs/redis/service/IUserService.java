package com.gdufs.redis.service;

import com.gdufs.redis.domain.User;
import org.springframework.cache.annotation.CachePut;

public interface IUserService {

    /**
     * 方法调用的返回值（不能用在@Cacheable注解上）,表达式#result能够得到返回的User
     *
     * @param user
     * @return
     */
    @CachePut(value = "RKOO", key = "#result.id")
    User insert(User user);

    User get(Integer id);
}
