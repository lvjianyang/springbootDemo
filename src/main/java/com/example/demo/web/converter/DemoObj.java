package com.example.demo.web.converter;

/**
 * Created by Administrator on 2018/6/25.
 */
public class DemoObj {
    private long id;

    public DemoObj(Long aLong, String s) {
        this.id=aLong;
        this.name=s;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
