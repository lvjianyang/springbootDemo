package com.example.demo.web.validate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2018/6/25.
 */
public class ValidBean {
    @NotNull(message = "名字不能为空")
    private String name;

    @Min(value = 18, message = "年龄必须大于18")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
