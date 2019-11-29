package com.example.demo.web.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2018/6/25.
 */
@SpringBootConfiguration
public class WebAppConfig extends WebMvcConfigurerAdapter {
@Autowired
private InterceptorConfig interceptorConfig;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(interceptorConfig).addPathPatterns("/api/path/**").excludePathPatterns("/api/path/login");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // ...
    }
}