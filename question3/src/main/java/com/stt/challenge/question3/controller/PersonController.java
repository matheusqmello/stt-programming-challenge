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
    
    private static final String ATTRIBUTE_PERSON = "person";
    private static final String ATTRIBUTE_GENDERS = "genders";
    private static final String ATTRIBUTE_LIST_PERSONS = "listPersons";
    private static final String ATTRIBUTE_PAGE_TITLE = "pageTitle";
    private static final String ATTRIBUTE_SUCCESS_MSG = "successMessage";

    private static final String TITLE_CREATE = "Create";
    private static final String TITLE_EDIT = "Edit";

    private static final String HTML_CREATE = "createPerson";
    private static final String HTML_LIST = "listPersons";

    private static final String ENDPOINT_CREATE = "/person";
    private static final String ENDPOINT_LIST = "/person/list";
    private static final String ENDPOINT_EDIT = "/person/edit/{id}";
    private static final String ENDPOINT_DELETE = "/person/delete/{id}";
    
    @Autowired
    private PersonService personService;
    
    @Autowired
    private GenderService genderService;
    
    
    // PAGE HANDLING
    @GetMapping({ENDPOINT_CREATE, "/"})
    public String showCreatePage(Model model) {
        setAttribute(model, ATTRIBUTE_PAGE_TITLE, TITLE_CREATE);
        
        setGenderSelectOptions(model);
        
        setAttribute(model, ATTRIBUTE_PERSON, new Person());
        
        return HTML_CREATE; 
    }
    
    @GetMapping(ENDPOINT_EDIT)
    public String showUpdatePage(@PathVariable Integer id, Model model) {
        setAttribute(model, ATTRIBUTE_PAGE_TITLE, TITLE_EDIT);
        
        setGenderSelectOptions(model);
        
        Person person = personService.getById(id);
        
        setAttribute(model, ATTRIBUTE_PERSON, person);
        
        return HTML_CREATE; 
    }
    
    @GetMapping(ENDPOINT_LIST)
    public String showListPage(Model model) {
        List<Person> listPersons = personService.getAll();
        
        setAttribute(model, ATTRIBUTE_LIST_PERSONS, listPersons);
        
        return HTML_LIST; 
    }
    

    // ACTIONS
    @PostMapping(ENDPOINT_CREATE)
    public String createOrUpdatePerson(@Valid @ModelAttribute Person person, Model model) {
        personService.save(person);
        
        setGenderSelectOptions(model);

        setAttribute(model, ATTRIBUTE_PERSON, person);
        setAttribute(model, ATTRIBUTE_SUCCESS_MSG, "Done successfully.");
        
        return HTML_CREATE;
    }

    @PostMapping(ENDPOINT_DELETE)
    public String deletePerson(@PathVariable Integer id, Model model, RedirectAttributes redirAtt) {
        personService.delete(id);
        
        setAttribute(redirAtt, ATTRIBUTE_SUCCESS_MSG, "Deleted successfully.");
        
        return "redirect:"+ENDPOINT_LIST;
    }
    
    
    // AUX METHODS
    private void setGenderSelectOptions(Model model) {
        List<Gender> genders = genderService.getAll();
        setAttribute(model, ATTRIBUTE_GENDERS, genders);
    }
    
    private void setAttribute(Model model, String attribute, Object value) {
        if (model instanceof RedirectAttributes) {
            ((RedirectAttributes) model).addFlashAttribute(attribute, value);
        } else {
            model.addAttribute(attribute, value);
        }
    }
}