package com.example.demo.web.formatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/25.
 */
@Data
public class Bean {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date time;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time1;
}
