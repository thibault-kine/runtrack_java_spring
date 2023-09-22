package com.example.demo.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.PersonEntity;
import com.example.demo.services.PersonService;


@Controller
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/users")
    public String UsersView(Model model) {
        
        List<PersonEntity> persons = service.getAll();
        model.addAttribute("persons", persons);

        return "users";
    }

    @PostMapping("/users/delete")
    public String UsersDelete(@RequestParam("id") int id) {

        service.deletePerson(id);
        return "redirect:/users";
    }

    @PostMapping("/users/submit") 
    public String UsersUpdate(
        @RequestParam("id") int id,
        @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName,
        @RequestParam("age") int age,
        @RequestParam("email") String email,
        @RequestParam("password") String password
    ) {
        service.updatePerson(id, firstName, lastName, age, email, password);

        return "redirect:/users";
    }

    @GetMapping("/newUser") 
    public String NewUserView() {

        return "newUser";
    }

    @PostMapping("/newUser/submit") 
    public String NewUserSubmit(
        @RequestParam("id") int id,
        @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName,
        @RequestParam("age") int age,
        @RequestParam("email") String email,
        @RequestParam("password") String password
    ) {
        service.createPerson(firstName, lastName, age, email, password);

        return "redirect:/users";
    }
}
