package com.example.test.controller;

import com.example.test.service.PersonService;
import com.example.test.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.test.bean.Person;
import com.example.test.bean.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WebController {
    @Autowired
    private PersonService personService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/index")
    public String startPage() {
        return "index";
    }

    @RequestMapping(value = "/databaseDetail")
    public String queryDatabase(Model model){
        List<Person> databasePerson = personService.findAll();
        List<Users> databaseUsers = usersService.findAll();
        Map<String,List> database  = new HashMap<>();
        database.put("person",databasePerson);
        database.put("users",databaseUsers);

        model.addAttribute("data", database);
        return "database";
    }
}
