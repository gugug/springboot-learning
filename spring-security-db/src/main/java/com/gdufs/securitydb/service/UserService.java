package com.gdufs.securitydb.service;

import com.gdufs.securitydb.entity.UserEntity;

/**
 * Created by gucailiang on 2018/1/10.
 */
public interface UserService {

    /**
     * 添加新用户
     *
     * username 唯一， 默认 USER 权限
     */
    boolean insert(UserEntity userEntity);

    /**
     * 查询用户信息
     * @param username 账号
     * @return UserEntity
     */
    UserEntity getByUsername(String username);
}
