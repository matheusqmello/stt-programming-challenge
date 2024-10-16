package com.stt.challenge.question3.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;

@ControllerAdvice
public class PersonControllerAdvice {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBindException(BindException ex, Model model) {
        model.addAttribute("errorMessage", getErrorMessage(model, ex));
        return "error"; 
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", getErrorMessage(model, ex));
        return "error";
    }
    
    private Object getErrorMessage(Model model, Exception ex) {
        if (ex instanceof BindException) {
            return "Check your input: " +
                    ((BindException) ex).getFieldError().getField() + ": " + 
                    ((BindException) ex).getFieldError().getDefaultMessage();
        } else {
            return "Error: " + ex.getMessage();
        }
    }
}
