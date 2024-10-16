package com.stt.challenge.question3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stt.challenge.question3.model.Gender;
import com.stt.challenge.question3.model.Person;
import com.stt.challenge.question3.service.GenderService;
import com.stt.challenge.question3.service.PersonService;

@Controller
public class PersonController {
    
    private static final String ATT_PAGE_TITLE = "pageTitle";
    private static final String ATT_SUCCESS_MSG = "successMessage";

    private static final String TITLE_CREATE = "Create";
    private static final String TITLE_EDIT = "Edit";

    @Autowired
    private PersonService personService;
    
    @Autowired
    private GenderService genderService;
    
    
    // PAGES
    @GetMapping({"/", "/person", "/index", "/home"})
    public String showCreatePage(Model model) {
        setAttribute(model, ATT_PAGE_TITLE, TITLE_CREATE);
        
        setGenderSelectOptions(model);
        
        model.addAttribute("person", new Person());
        
        return "createPerson"; 
    }
    
    @GetMapping("/person/{id}")
    public String showUpdatePage(@PathVariable Integer id, Model model) {
        setAttribute(model, ATT_PAGE_TITLE, TITLE_EDIT);
        
        setGenderSelectOptions(model);
        
        Person person = personService.getById(id);
        model.addAttribute("person",person);
        
        return "createPerson"; 
    }
    
    @GetMapping("/persons")
    public String showListPage(Model model) {
        
        List<Person> listPersons = personService.getAll();
        model.addAttribute("listPersons",listPersons);
        
        log("ListPersons msg: "+model.getAttribute(ATT_SUCCESS_MSG));
        
        return "listPersons"; 
    }
    

    // ACTIONS
    @PostMapping("/person")
    public String createOrUpdatePerson(@Valid @ModelAttribute Person person, Model model) {
        personService.save(person);
        
        setGenderSelectOptions(model);
        
        model.addAttribute("person", person);
        
        setAttribute(model, ATT_SUCCESS_MSG, "Done successfully.");
        
        return "createPerson";
    }

    @PostMapping("/person/{id}/delete")
    public String deletePerson(@PathVariable Integer id, Model model, RedirectAttributes redirModel) {
        personService.delete(id);
        
        setAttribute(redirModel, ATT_SUCCESS_MSG, "Deleted successfully.");
        
        return "redirect:/persons";
    }
    
    
    // AUX METHODS
    private void setGenderSelectOptions(Model model) {
        List<Gender> genders = genderService.getAll();
        model.addAttribute("genders", genders);
    }
    
    private void setAttribute(Model model, String attribute, Object value) {
        if (model instanceof RedirectAttributes) {
            ((RedirectAttributes) model).addFlashAttribute(attribute, value);
            log("Redir: "+attribute+": "+value);
        } else {
            model.addAttribute(attribute, value);
            log("Attrib: "+attribute+": "+value);
        }
        
    }
    
    private void log(String msg) {
        System.out.println(msg);
    }
}