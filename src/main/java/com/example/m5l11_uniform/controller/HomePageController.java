package com.example.m5l11_uniform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

    @RequestMapping(method = RequestMethod.GET, value = "/") // localhost:8080/
    public String getHomePage(){
        System.out.println("Controller HomePageController is actioned");
        return "redirect:/users/"; // -> localhost:8080/users/
    }

}
