package com.example.test.controller;

import com.example.test.bean.Users;
import com.example.test.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class UserController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/deletePersonAndUser")
    public String delete(Users users, Map<String,Object> map) {
        map.put("user",users);
        usersService.deleteUsers(users.getUsername());
        return "deleteOperationResult";
    }
}

