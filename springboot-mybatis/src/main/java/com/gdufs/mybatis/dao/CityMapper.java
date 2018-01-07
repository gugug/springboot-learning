package com.gdufs.mybatis.dao;

import com.gdufs.mybatis.entity.City;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Created by gu on 2018/1/7.
 */
@Repository
@Mapper // 标志为 Mybatis 的 Mapper
public interface CityMapper {

    @Select("SELECT * FROM city WHERE cityName = #{cityName}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    City findByName(@Param("cityName") String cityName);

    @Select("SELECT * FROM city WHERE id = #{id}")
    City findCityById(Long id);
}
