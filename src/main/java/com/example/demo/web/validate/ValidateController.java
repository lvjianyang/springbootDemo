package com.example.demo.web.validate;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Set;

/**
 * Created by Administrator on 2018/6/25.
 */
@Controller
@Validated
public class ValidateController {
    //http://localhost:8080/bean?age=19&name=2
    //对封装的bean进行验证 1 添加bean设置验证2方法设置验证类及返回结果BindingResult
    @RequestMapping("bean")
    @ResponseBody
    public String say(@Valid ValidBean bean, BindingResult bindingResult){
        return bindingResult.hasErrors() ?
                bindingResult.getFieldError().getDefaultMessage() : "correct";
    }


    //方法参数进行验证1类添加@Validated2方法添加校验3添加异常处理类
    @RequestMapping("/check")
    @ResponseBody
    public String check(@Min(value = 2,message = "age必须大于2") int age) {
        return "" + age;
    }
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseBody
    public String handleResourceNotFoundException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations ) {
            strBuilder.append(violation.getMessage() + "\n");
        }
        return strBuilder.toString();
    }
}
