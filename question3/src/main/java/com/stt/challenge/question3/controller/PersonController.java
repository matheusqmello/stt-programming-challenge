package com.stt.challenge.question3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stt.challenge.question3.model.Person;

@Controller
public class PersonController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("person", new Person());
        return "home"; 
    }
    
    @PostMapping("/person/create")
    public String createPerson(@ModelAttribute Person person) {
        
        // personService.save(person);
        
        return "";
    }
}