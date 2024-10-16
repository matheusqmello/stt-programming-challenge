package com.stt.challenge.question3.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(Model model) {
        model.addAttribute("errorMessage", getErrorMessage(model));
        return "error";
    }

    private String getErrorMessage(Model model) {
        return "There was a general error: "+model.getAttribute("error")+" "+model.getAttribute("message");
    }

}
