package com.gdufs.girl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gu on 2017/12/3.
 */
@Controller
public class HelloController1 {

    @RequestMapping(value = "helloThymeleaf")
    public String helloThymeleaf(){
        return "index";
    }

}
