package com.gdufs.securitydb.service.impl;

import com.gdufs.securitydb.dao.UserMapper;
import com.gdufs.securitydb.entity.UserEntity;
import com.gdufs.securitydb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gucailiang on 2018/1/10.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean insert(UserEntity userEntity) {
        String username = userEntity.getUsername();
        UserEntity selRet = userMapper.selectByUsername(username);
        if (selRet != null)
            return false;
        userEntity.setRoles("ROLE_USER");
        int result = userMapper.insert(userEntity);
        return result == 1;
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
