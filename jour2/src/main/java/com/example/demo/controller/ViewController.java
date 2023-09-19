package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Dictionary;
import java.util.Hashtable;

@Controller
public class ViewController {

    @GetMapping("/")
    public String View(Model model) {
        Dictionary<String, String> utilisateur = new Hashtable<>();
        utilisateur.put("prenom", "Thibault");
        utilisateur.put("nom", "Kine");
        utilisateur.put("age", "21");

        model.addAttribute("utilisateur", utilisateur);

        return "view";
    }
}
