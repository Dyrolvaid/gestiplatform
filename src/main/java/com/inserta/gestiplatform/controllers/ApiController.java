package com.inserta.gestiplatform.controllers;

import com.inserta.gestiplatform.models.*;
import com.inserta.gestiplatform.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/plataformas")
    public List<Plataforma> plataformas(){
        return plataformasRepo.findAll();
    }
    @RequestMapping("/personas")
    public List<Persona> personas(){
        return personasRepo.findAll();
    }

    @RequestMapping("/personas/{id}")
    public Persona personaById(@PathVariable Integer id) {
        return personasRepo.findById(id).get();
    }

    @RequestMapping("/personas/findByCorreoAndClave/{correo}/{clave}")
    public Persona personaByCorreoAndClave(@PathVariable String correo, @PathVariable String clave){
        return personasRepo.findByCorreoAndClave(correo, clave);
    }

    @RequestMapping("/periodicidades")
    public List<Periodicidad> periodicidades(){
        return periodicidadesRepo.findAll();
    }
    @RequestMapping("/grupos")
    public List<Grupo> grupos(){
        return gruposRepo.findAll();
    }
    @RequestMapping("/formasdepago")
    public List<FormaDePago> formasdepago(){
        return formasDePagoRepo.findAll();
    }
    @RequestMapping("/suscripciones")
    public List<Suscripcion> suscripciones(){
        return suscripcionesRepo.findAll();
    }
    @RequestMapping("/recibos")
    public List<Recibo> recibos(){
        return recibosRepo.findAll();
    }
}
