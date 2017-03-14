package com.marissaman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by saras on 2017/3/14.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hhhhh";
    }
}
