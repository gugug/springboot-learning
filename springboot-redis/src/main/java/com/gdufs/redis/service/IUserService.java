package com.gdufs.redis.service;

import com.gdufs.redis.domain.User;

public interface IUserService {
    void insert(User user);

    User get(Integer id);
}
