package com.inserta.gestiplatform.controllers;

import com.inserta.gestiplatform.models.*;
import com.inserta.gestiplatform.repositories.*;
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
    @Autowired
    PeriodicidadesRepo periodicidadesRepo;
    @Autowired
    GruposRepo gruposRepo;
    @Autowired
    FormasDePagoRepo formasDePagoRepo;
    @Autowired
    SuscripcionesRepo suscripcionesRepo;
    @Autowired
    RecibosRepo recibosRepo;
    @GetMapping("/plataformas")
    public List<Plataforma> plataformas(){
        return plataformasRepo.findAll();
    }
    @GetMapping("/personas")
    public List<Persona> personas(){
        return personasRepo.findAll();
    }
    @GetMapping("/periodicidades")
    public List<Periodicidad> periodicidades(){
        return periodicidadesRepo.findAll();
    }
    @GetMapping("/grupos")
    public List<Grupo> grupos(){
        return gruposRepo.findAll();
    }
    @GetMapping("/formasdepago")
    public List<FormaDePago> formasdepago(){
        return formasDePagoRepo.findAll();
    }
    @GetMapping("/suscripciones")
    public List<Suscripcion> suscripciones(){
        return suscripcionesRepo.findAll();
    }
    @GetMapping("/recibos")
    public List<Recibo> recibos(){
        return recibosRepo.findAll();
    }
}
