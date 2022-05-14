package com.inserta.gestiplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlataformasController {
    @RequestMapping("/plataformas")
    public String plataformas() {
        return "index";
    }

}
