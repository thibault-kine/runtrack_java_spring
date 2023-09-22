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
        // Si la base de données est vide, ajouter des entrées
        if(persons.isEmpty()) {
            service.createPerson("Thibault", "Kine", 21);
            service.createPerson("Ibrahim", "Sylla", 21);
            service.createPerson("Cyril", "Porez", 34);
            service.createPerson("Jean", "Bonbeurre", 41);
            service.createPerson("Elon", "Musk", 52);
            service.createPerson("Roxan", "Roumégas", 45);
            persons = service.getAll();
        }
        
        model.addAttribute("persons", persons);

        return "users";
    }

    @PostMapping("/delete")
    public String UsersDelete(@RequestParam("id") int id) {
        service.deletePerson(id);
        return "redirect:/users";
    }

    @PostMapping("/submit") 
    public String UsersUpdate(
        @RequestParam("id") int id,
        @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName,
        @RequestParam("age") int age
    ) {
        service.updatePerson(id, firstName, lastName, age);

        return "redirect:/users";
    }
}
