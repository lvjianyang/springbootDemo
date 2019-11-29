package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        ConfigBean bean =new ConfigBean();
        bean.setName("hello");
        return "Hello World";
    }


    @RequestMapping("/map")
    public Map map() {
        Map map =new HashMap();
        map.put("key","value");
        return map;
    }
    @RequestMapping("/list")
    public List list() {
        List l=new ArrayList<Map>();
        Map map =new HashMap();
        map.put("key","value");
        l.add(map);
        return l;
    }
}