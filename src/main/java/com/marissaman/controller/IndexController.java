package com.marissaman.controller;

import com.marissaman.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by saras on 2017/3/14.
 */
@Controller
public class IndexController {

    @RequestMapping(path = {"/","/index"})
    @ResponseBody
    public String index(){
        return "hhhhh";
    }

    @RequestMapping(value = {"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("groupId") String groupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value = "type",
                          defaultValue = "1") int type,
                          @RequestParam(value = "key",
                          defaultValue = "marissaman") String key){
        return String.format("GID{%s},UID{%d},TYPE{%d},KEY{%s}", groupId,userId,type,key);
    }

    @RequestMapping(value = {"/vm"})
    public String news(Model model){
        model.addAttribute("value1","vv1");
        List<String> colors = Arrays.asList(new String[] {"RED","GREEN","BLUE"});

        Map<String,String> map = new HashMap<String,String>();
        for(int i=0;i<4;++i){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }

        model.addAttribute("colors",colors);
        model.addAttribute("map",map);
        model.addAttribute("user",new User("jim"));
        return "news";
    }

    @RequestMapping(value = {"/request"})
    @ResponseBody
    public String request(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpSession session){
        StringBuilder sb = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            sb.append(name + ":" + request.getHeader(name) +"<br>");
        }

        for(Cookie cookie: request.getCookies()){
            sb.append("Cookie：");
            sb.append(cookie.getName());
            sb.append(":");
            sb.append(cookie.getValue());
            sb.append("<br>");
        }

        sb.append("getMethod:"+request.getMethod()+"<br>");
        sb.append("getPathInfo:" + request.getPathInfo()+"<br>");
        sb.append("getQueryString" + request.getQueryString()+"<br>");
        sb.append("getRequestURI" + request.getRequestURI()+"<br>");
        return sb.toString();
    }

    @RequestMapping(value = {"/response"})
    @ResponseBody
    public  String response(@CookieValue(value = "one",defaultValue = "wen") String id,
                            @RequestParam(value = "key",defaultValue = "2") String key,
                            @RequestParam(value = "value",defaultValue = "3") String value,
                            HttpServletResponse response){
        response.addCookie(new Cookie(key,value));
        response.addHeader(key,value);
        return "one From Cookie:" + id;

    }
}
