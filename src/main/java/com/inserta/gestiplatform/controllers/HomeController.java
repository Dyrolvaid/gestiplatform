package com.inserta.gestiplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {
    @GetMapping("/")
    public String inicio() {
        return "hall";
    }
    @GetMapping("/acceso")
    public String acceso(HttpSession session, Model model) {
        model.addAttribute("logoYaPulsado", true);
        if (session.getAttribute("usuarioActivo") == null){
            return "hall";
        } else {
            return "api";
        }

    }
}
