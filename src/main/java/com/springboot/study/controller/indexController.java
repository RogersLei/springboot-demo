package com.springboot.study.controller;

import com.springboot.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.study.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @RestController
// @RestController  @Controller  @ResponseBody
// @RestController注解是@Controller和@ResponseBody的合集,表示这是个控制器bean,并且是将函数的返回值直 接填入HTTP响应体中,是REST风格的控制器。
@Controller
public class indexController {
    @Autowired
    private IUserService userService;

    @RequestMapping("")
    private String index () {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/userlist")
    private String userlist (Map<String,List> result) {
        System.out.println("userlist");
        List<User> user = userService.findAllUser();

        System.out.println("controller user" + user);

        List list = new ArrayList();
        Map<String,String> map = new HashMap<String,String>();
        map.put("user_name","bb");
        map.put("user_pwd","cc");
        map.put("user_desc","dd");
        list.add(map);
        System.out.println("controller users" + list);
        result.put("users", list);
        return "user/userlist";
    }

    @RequestMapping("/adduser")
    private String adduser () {
        System.out.println("adduser");
        return "user/adduser";
    }

    @RequestMapping("/userlistById")
    private String userlistById (Map<String,List> result) {
        List list = new ArrayList();
        Map<String,String> map = new HashMap<String,String>();
        map.put("user_name","dd");
        map.put("user_pwd","ee");
        map.put("user_desc","ff");
        list.add(map);
        System.out.println("controller byid" + list);
        result.put("users", list);
        return "user/userlist::usertable";
    }


}
