package com.gdufs.mybatis.service.impl;

import com.gdufs.mybatis.entity.City;
import com.gdufs.mybatis.service.CityService;
import com.gdufs.mybatis.dao.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> findAllCity() {
        return null;
    }

    @Override
    public City findCityById(Long id) {
        return cityMapper.findCityById(id);
    }

    @Override
    public Long saveCity(City city) {
        return null;
    }

    @Override
    public Long updateCity(City city) {
        return null;
    }

    @Override
    public Long deleteCity(Long id) {
        return null;
    }
}
