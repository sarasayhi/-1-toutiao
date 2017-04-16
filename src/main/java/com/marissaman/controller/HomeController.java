package com.marissaman.controller;

import com.marissaman.service.NewsService;
import com.marissaman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by saras on 2017/4/16.
 */
@Controller
public class HomeController {
    @Autowired
    NewsService newsService;

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/", "/index"})
    @ResponseBody
    public String index(HttpSession session) {
        return "home";
    }

}
