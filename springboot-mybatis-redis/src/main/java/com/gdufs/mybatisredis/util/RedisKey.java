package com.gdufs.mybatisredis.util;

import com.gdufs.mybatisredis.entity.City;

public class RedisKey {

    public static String getCityKey(City city) {
        String key = "city_" + city.getId();
        return key;
    }

    public static String getCityKey(Long cityid) {
        String key = "city_" + cityid;
        return key;
    }
}
