package com.example.demo.web.converter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/6/25.
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/convert" ,produces = { "application/x-longjiazuo" }) //①
    public @ResponseBody
    DemoObj convert(@RequestBody DemoObj demoObj) {
        return demoObj;
    }
}
