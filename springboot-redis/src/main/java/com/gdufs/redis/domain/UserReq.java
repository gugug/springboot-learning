package com.gdufs.redis.domain;

/**
 * @author gucailiang
 * @date 2018/9/6
 */
public class UserReq {

    private Integer id;
    private Integer code;
    private System name;

    @Override
    public String toString() {
        return "UserReq{" +
                "id=" + id +
                ", code=" + code +
                ", name=" + name +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public System getName() {
        return name;
    }

    public void setName(System name) {
        this.name = name;
    }
}
