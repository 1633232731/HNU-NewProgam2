package com.example.test.controller;

import com.example.test.bean.Person;
import com.example.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/listPerson")
    public String listUser(Model model) {
        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "listPerson";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "/addPersonFourParams";
    }



    // 这次实验主要用这个函数
    @RequestMapping(value = "/addOrUpdatePerson")
    public String add(Person person, Map<String,Object> map) {
        personService.addOrUpdatePerson(person);
        map.put("person",person);
        return "addOperationResult";
        //return "redirect:/listPerson";
    }


    @RequestMapping("/toUpdate")
    public String toUpdate(Model model, String username) {
        Person person = personService.findByUsername(username);
        model.addAttribute("person", person);
        return "/updatePerson";
    }

    @RequestMapping("/update")
    public String updatePerson(Person person) {
        personService.updatePerson(person);
        return "redirect:/listPerson";
    }

    @RequestMapping("/delete")
    public String deletePerson(String username) {
        personService.deletePerson(username);
        return "redirect:/listPerson";
    }
}
