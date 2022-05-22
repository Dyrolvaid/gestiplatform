package com.inserta.gestiplatform.controllers;

import com.inserta.gestiplatform.models.Persona;
import com.inserta.gestiplatform.repositories.PersonasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class PersonasController {
    @Autowired
    PersonasRepo personasRepo;
    @PostMapping("/login")
    public String login(@RequestParam String correo, @RequestParam String clave, HttpSession session, Model model) {
        Persona usuarioEncontrado = personasRepo.findByCorreoAndClave(correo, clave);
        if (usuarioEncontrado != null) {
            session.setAttribute("usuarioActivo", usuarioEncontrado);
            return "api";
        } else {
            model.addAttribute("logoYaPulsado", true);
            model.addAttribute("usuarioErroneo", true);
            return "hall";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "hall";
    }
}
