package com.example.demo.web.formatter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class FormatterController {

    @RequestMapping("/format")
    public Bean index() {
       Bean bean =new Bean();
        bean.setTime(new Date());
        bean.setTime1(new Date());
        return bean;
    }


}