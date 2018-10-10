package com.gdufs.rest.exception;

/**
 * @author gucailiang
 * @date 2018/10/10
 */
public class CityNotFoundException extends RuntimeException {
    private long cityId;

    public CityNotFoundException(long cityId) {
        this.cityId = cityId;
    }

    public long getCityId() {
        return cityId;
    }
}
