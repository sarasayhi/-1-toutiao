package com.marissaman.controller;

import com.marissaman.model.News;
import com.marissaman.model.ViewObject;
import com.marissaman.service.NewsService;
import com.marissaman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saras on 2017/4/16.
 */
@Controller
public class HomeController {
    @Autowired
    NewsService newsService;

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        List<News> newsList = newsService.getLatesNews(0, 0, 10);

        List<ViewObject> vos = new ArrayList<ViewObject>();
        for(News news : newsList){
            ViewObject vo = new ViewObject();
            vo.set("news",news);
            vo.set("user", userService.getUser(news.getUserId()));
            vos.add(vo);
        }

        model.addAttribute("vos", vos);
        return "home";
    }

}
