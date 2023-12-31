package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Dictionary;
import java.util.Hashtable;

@Controller
public class ViewController {

    @GetMapping("/job1")
    public String Job1() {
        return "view_job1";
    }

    @GetMapping("/job2")
    public String Job2(Model model) {
        Dictionary<String, String> utilisateur = new Hashtable<>();
        utilisateur.put("prenom", "Thibault");
        utilisateur.put("nom", "Kine");
        utilisateur.put("age", "21");

        model.addAttribute("utilisateur", utilisateur);

        return "view_job2";
    }

    @GetMapping("/job3")
    public String Job3Form(MyForm form) {
        return "view_job3";
    }

    @PostMapping("/job3/welcome")
    public String Job3Submit(@ModelAttribute @Validated MyForm form, Model model, BindingResult bindingResult) {
        String message = String.format("Bienvenue, %s !", form.getFname());
        model.addAttribute("message", message);

        if(!bindingResult.hasErrors()) return "view_job3_welcome";
        else return "view_job3_errors";
    }
}
