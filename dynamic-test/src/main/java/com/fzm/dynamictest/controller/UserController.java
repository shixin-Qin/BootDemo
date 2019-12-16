package com.fzm.dynamictest.controller;

import com.fzm.dynamictest.po.User;
import com.fzm.dynamictest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(){
        return "哈哈";
    }

    @RequestMapping("/list")
    public List<User> getUsers(){
        return userService.list();
    }

}
