package com.example.demo.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interfaces.PersonRepository;
import com.example.demo.models.PersonEntity;

@Controller
public class PersonController {

    @Autowired
    PersonRepository repo;

    private void createPerson(String fname, String lname, int age) {
        PersonEntity p = new PersonEntity(fname, lname, age);
        repo.save(p);
    }

    @GetMapping("/users")
    public String UsersView(Model model) {
        
        List<PersonEntity> persons = repo.findAll();
        // Si la base de données est vide, ajouter des entrées
        if(persons.size() == 0) {
            createPerson("Thibault", "Kine", 21);
            createPerson("Ibrahim", "Sylla", 21);
            createPerson("Cyril", "Porez", 34);
            createPerson("Jean", "Bonbeurre", 41);
            createPerson("Elon", "Musk", 52);
            createPerson("Roxan", "Roumégas", 45);
            persons = repo.findAll();
        }
        
        model.addAttribute("persons", persons);

        return "users";
    }

    @PostMapping("/delete")
    public String UsersDelete(@RequestParam("id") int id) {
        repo.deleteById(id);
        return "redirect:/users";
    }

    @PostMapping("/submit") 
    public String UsersUpdate(
        @RequestParam("id") int id,
        @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName,
        @RequestParam("age") int age
    ) {
        PersonEntity currentPerson = repo.findById(id).get();
        currentPerson.setFirstName(firstName);
        currentPerson.setLastName(lastName);
        currentPerson.setAge(age);
        repo.save(currentPerson);

        return "redirect:/users";
    }
}
