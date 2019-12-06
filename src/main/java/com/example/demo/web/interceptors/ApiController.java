package com.example.demo.web.interceptors;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/6/25.
 */
@Controller
@RequestMapping(value = "/api" )
public class ApiController {

    @RequestMapping(value = "/path/convert" )
    @ResponseBody
    public  String convert() {
        return "api";
    }
    @RequestMapping(value = "/path/login" )
    @ResponseBody
    public  String login(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("userName","123");
        return "login";
    }
}
