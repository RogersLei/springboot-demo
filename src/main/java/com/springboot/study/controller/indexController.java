package com.springboot.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
 import org.springframework.stereotype.Controller;

// @RestController
// @RestController  @Controller  @ResponseBody
// @RestController注解是@Controller和@ResponseBody的合集,表示这是个控制器bean,并且是将函数的返回值直 接填入HTTP响应体中,是REST风格的控制器。
@Controller
public class indexController {

    @RequestMapping("")
    private String index () {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/userlist")
    private String userlist () {
        System.out.println("userlist");
        return "error";
    }

}
