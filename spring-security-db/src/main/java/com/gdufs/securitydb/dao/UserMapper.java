package com.gdufs.securitydb.dao;

import com.gdufs.securitydb.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by gucailiang on 2018/1/10.
 */
@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into user_entity(username, password, nickname, roles) values(#{username}, #{password}, #{nickname}, #{roles})")
    int insert(UserEntity userEntity);

    @Select("select * from user_entity where username = #{username}")
    UserEntity selectByUsername(@Param("username") String username);
}
