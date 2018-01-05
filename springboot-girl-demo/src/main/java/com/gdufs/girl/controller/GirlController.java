package com.gdufs.girl.controller;

import com.gdufs.girl.entity.Girl;
import com.gdufs.girl.dao.GirlRepository;
import com.gdufs.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gu on 2017/12/3.
 */
@RestController
public class GirlController {

    @Autowired
    GirlRepository girlRepository;

    @Autowired
    GirlService girlService;

    @GetMapping("girls")
    public List<Girl> getGirlList() {
        return girlRepository.findAll();
    }

    @PostMapping("girls")
    public Girl addGirlList(String cupSize, Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @GetMapping("girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping("girls/{id}")
    public Girl girdUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @DeleteMapping("girls/{id}")
    public void girdUpdate(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping("girls/age/{age}")
    public List<Girl> getGirlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @GetMapping("girls/two")
    @Transactional
    public void girlTwo() {
        girlService.insertTwo();
    }

}
