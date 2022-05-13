package com.inserta.gestiplatform.controllers;

import com.inserta.gestiplatform.models.Persona;
import com.inserta.gestiplatform.models.Plataforma;
import com.inserta.gestiplatform.repositories.PersonasRepo;
import com.inserta.gestiplatform.repositories.PlataformasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    PlataformasRepo plataformasRepo;
    @Autowired
    PersonasRepo personasRepo;
    @GetMapping("/plataformas")
    public List<Plataforma> plataformas(){
        return plataformasRepo.findAll();
    }
    @GetMapping("/personas")
    public List<Persona> personas(){
        return personasRepo.findAll();
    }
}
