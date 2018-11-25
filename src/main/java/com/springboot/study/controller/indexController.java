package com.springboot.study.controller;

import com.springboot.study.entity.File;
import com.springboot.study.entity.User;
import com.springboot.study.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.study.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    private IFileService fileService;

    @RequestMapping("")
    private String index () {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/userlist")
    private String userlist (Map<String,Object> result) {
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
//        result.put("users", user);
        return "user/userlist";
    }

    @RequestMapping("/adduser")
    private String adduser () {
        System.out.println("adduser");

        System.out.println("----------------------");


//        List<File> files = fileService.findAllFile();

//        System.out.println("----------------------"+files);
        return "user/adduser";
    }

    @RequestMapping("/userlistById")
    private String userlistById ( Map<String,List> result) {
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

//    @RequestMapping("/upload")
//    private String upload(MultipartFile file){
//
//        System.out.println(file);
//
//        return "user/userlist::usertable";
//    }


}
