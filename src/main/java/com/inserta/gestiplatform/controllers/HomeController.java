package com.inserta.gestiplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(HttpSession session){
        if (session.isNew()){
            return "login";
        } else {
            return "index";
        }
    }
}
