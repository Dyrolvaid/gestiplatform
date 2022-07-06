package com.inserta.gestiplatform.controllers;

import com.inserta.gestiplatform.models.*;
import com.inserta.gestiplatform.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
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
        return personasRepo.findById(id).orElse(null);
    }
    @RequestMapping("/personas/findByCorreoAndClave/{correo}/{clave}")
    public Persona personaByCorreoAndClave(@PathVariable String correo, @PathVariable String clave){
        return personasRepo.findByCorreoAndClave(correo, clave);
    }
    @RequestMapping("/personas/correo/{correo}")
    public Persona personaByCorreo(@PathVariable String correo) {
        return personasRepo.findByCorreo(correo);
    }

    @RequestMapping("/periodicidades")
    public List<Periodicidad> periodicidades(){
        return periodicidadesRepo.findAll();
    }

    @RequestMapping("/grupos")
    public List<Grupo> grupos(){
        return gruposRepo.findAll();
    }

    //UN POST A LA API V1!!!! OW, YEAH!!!
    //*********************************************************************************************
    @PostMapping(path = "/grupos", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> respuestaGrupo(@RequestBody Grupo grupo) {
        int id = gruposRepo.findAll().size() + 1;
        grupo.setId(id);
        List<Grupo> listaGrupos = gruposRepo.findAll();
        HttpStatus httpStatus = HttpStatus.NOT_MODIFIED;
        ResponseEntity<Object> error = new ResponseEntity<>(httpStatus);
        for (Grupo grupoIterado : listaGrupos) {
            if (grupo.getPersona().getId() == grupoIterado.getPersona().getId()
                    && grupo.getSuscripcion().getId() == grupoIterado.getSuscripcion().getId()) {
                System.out.println("Esta persona ya está suscrita.");
                return error;
            }
        }
        gruposRepo.save(grupo);
        //grupos().add(grupo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(grupo.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    //***********************************************************************************************

    @RequestMapping("/grupos/{id}")
    public Grupo grupoById(@PathVariable Integer id) {
        return gruposRepo.findById(id).orElse(null);
    }
    @RequestMapping("/grupos/persona/{id}")
    public List<Grupo> gruposPorPersonaId(@PathVariable Integer id) {
        Persona personaFiltrar = personasRepo.findById(id).orElse(null);
        return gruposRepo.findByPersona(personaFiltrar);
    }
    @RequestMapping("/grupos/suscripcion/{id}")
    public List<Grupo> gruposPorSuscripcionId(@PathVariable Integer id) {
        Suscripcion suscripcionFiltrar = suscripcionesRepo.findById(id).orElse(null);
        return gruposRepo.findBySuscripcion(suscripcionFiltrar);
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
    @RequestMapping("/recibos/grupos/{idGrupo}")
    public List<Recibo> recibosByGroup(@PathVariable Integer idGrupo) {
        Grupo grupoFiltrar = gruposRepo.findById(idGrupo).orElse(null);
        return recibosRepo.findByGrupo(grupoFiltrar);
    }

    @RequestMapping("/recibos/suscripcion/{idSuscripcion}")
    public List<Recibo> recibosBySuscripcionId(@PathVariable Integer idSuscripcion) {
        Suscripcion suscripcion = suscripcionesRepo.findById(idSuscripcion).orElse(null);
        List<Recibo> listaRecibos = recibosRepo.findAll();
        List<Recibo> listaRecibosFiltrar = new ArrayList<>();
        for (Recibo recibo : listaRecibos) {
            if (suscripcion != null && recibo.getGrupo().getSuscripcion().getId() == suscripcion.getId()) {
                listaRecibosFiltrar.add(recibo);
            }
        }
        return listaRecibosFiltrar;
    }

}
