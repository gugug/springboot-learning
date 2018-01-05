package com.gdufs.jpa.service;

import com.gdufs.jpa.dao.CityRepository;
import com.gdufs.jpa.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gu on 2017/12/4.
 */
@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public void insertTwo() {
        City cityA = new City();
        cityRepository.save(cityA);

        City cityB = new City();
        cityRepository.save(cityB);

    }

    public City findById(Long id) {
        return cityRepository.findById(id);
    }

    public List<City> findByProvinceId(Long provinceId) {
        return cityRepository.findByProvinceId(provinceId);
    }

    public List<City> findByCityName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }

    public City findAllByProvinceIdAndAndCityName(Long provinceId, String cityName) {
        return cityRepository.findAllByProvinceIdAndAndCityName(provinceId, cityName);
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City insert(City city) {
        return cityRepository.save(city);
    }

    public City update(City city) {
        return cityRepository.save(city);
    }

    public void delete(City city) {
        cityRepository.delete(city);
    }

    public void deleteById(long cityID) {
        cityRepository.delete(cityID);
    }
}
