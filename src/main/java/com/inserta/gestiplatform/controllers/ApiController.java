package com.inserta.gestiplatform.controllers;

import com.inserta.gestiplatform.models.*;
import com.inserta.gestiplatform.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/v1")
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

//    @PersistenceContext
//    EntityManagerFactory entityManagerFactory;

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
//    @PostMapping(path = "/grupos", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Object> respuestaGrupo(@RequestBody Grupo grupo) {
//        Grupo grupoConUltimaId = gruposRepo.findTopByOrderByIdDesc(gruposRepo.findAll());
//        grupo.setId(grupoConUltimaId.getId() + 1);
//        List<Grupo> listaGrupos = gruposRepo.findAll();
//        HttpStatus httpStatus = HttpStatus.NOT_MODIFIED;
//        ResponseEntity<Object> error = new ResponseEntity<>(httpStatus);
//        for (Grupo grupoIterado : listaGrupos) {
//            if (grupo.getPersona().getId().equals(grupoIterado.getPersona().getId())
//                    && grupo.getSuscripcion().getId().equals(grupoIterado.getSuscripcion().getId())) {
//                System.out.println("Esta persona ya está suscrita.");
//                return error;
//            }
//        }
//        gruposRepo.save(grupo);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(grupo.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
    //***********************************************************************************************
//    @DeleteMapping(path="/grupos/{id}"/*consumes = "application/json", produces = "application/json"*/)
//    public /*ResponseEntity<Grupo>*/ void deleteGrupoByPersona(@PathVariable Integer id) {
//        List<Grupo> listaGruposByPersonaId = gruposRepo.findByPersonaId(id);
//        List<Suscripcion> listaSuscripciones = suscripcionesRepo.findAll();
//        for (Suscripcion suscripcionIterada : listaSuscripciones){
//            for (Grupo grupoIterado: listaGruposByPersonaId){
//                if (grupoIterado.getSuscripcion().getId() == suscripcionIterada.getId()){
//                    Grupo grupoEncontrado = entityManager.find(Grupo.class, grupoIterado.getId());
//                    entityManager.remove(grupoEncontrado);
//                    entityManager.close();
//                }
//
//            }
//        }
//        return gruposRepo.deleteByPersona(persona);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("")
//                .buildAndExpand(persona)
//                .toUri();
//        return ResponseEntity.created(location).build();

//        return gruposRepo.findAll().remove(grupo);
//    }
    @RequestMapping("/grupos/{id}")
    public Grupo grupoById(@PathVariable Integer id) {
        return gruposRepo.findById(id).orElse(null);
    }
    @RequestMapping("/grupos/persona/{id}")
    public List<Grupo> gruposPorPersonaId(@PathVariable Integer id) {
        return gruposRepo.findByPersonaId(id);
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
    @RequestMapping("/plataformas/{id}")
    public Plataforma plataformaById(@PathVariable Integer id) {
        return plataformasRepo.findById(id).orElse(null);
    }


    //Puede parecer que no, pero los siguientes dos métodos hacen lo que se espera de ellos.
    @RequestMapping("/recibos/suscripcion/{idSuscripcion}")
    public List<Recibo> recibosBySuscripcionId(@PathVariable Integer idSuscripcion) {
        Suscripcion suscripcion = suscripcionesRepo.findById(idSuscripcion).orElse(null);
        List<Recibo> listaRecibos = recibosRepo.findAll();
        List<Recibo> listaRecibosFiltrar = new ArrayList<>();
        for (Recibo recibo : listaRecibos) {
            if (suscripcion != null && recibo.getGrupo().getSuscripcion().getId().equals(suscripcion.getId())) {
                listaRecibosFiltrar.add(recibo);
            }
        }
        return listaRecibosFiltrar;
    }

    @RequestMapping("/recibos/persona/{idPersona}")
    public List<Recibo> recibosByPersonaId(@PathVariable Integer idPersona) {
        Persona persona = personasRepo.findById(idPersona).orElse(null);
        List<Recibo> listaRecibos = recibosRepo.findAll();
        List<Recibo> listaRecibosFiltrar = new ArrayList<>();
        for (Recibo recibo : listaRecibos) {
            if (persona != null && recibo.getGrupo().getPersona().getId().equals(persona.getId())) {
                listaRecibosFiltrar.add(recibo);
            }
        }
        return listaRecibosFiltrar;
    }

    //TODOS LOS POST DE V1 AQUÍ ABAJO
    @PostMapping(path = "/grupos", consumes = "application/json", produces = "application/json")
    public /*ResponseEntity<Object>*/ /*Grupo*/ void respuestaGrupo(@RequestBody Grupo grupo) {
        Grupo grupoConUltimaId = gruposRepo.findTopByOrderByIdDesc();
        grupo.setId(grupoConUltimaId.getId() + 1);
        gruposRepo.save(grupo);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(grupo.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//        return grupo;
    }
    @PostMapping(path = "/suscripciones", consumes = "application/json", produces = "application/json")
    public /*ResponseEntity<Object>*/ /*Suscripcion*/ void respuestaSuscripcion(@RequestBody Suscripcion suscripcion) {
        Suscripcion suscripcionConUltimaId = suscripcionesRepo.findTopByOrderByIdDesc();
        suscripcion.setId(suscripcionConUltimaId.getId() + 1);
        suscripcionesRepo.save(suscripcion);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(suscripcion.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//        return suscripcion;
    }

    @PostMapping(path = "/recibos", consumes = "application/json", produces = "application/json")
    public /*ResponseEntity<Object>*/ /*Recibo*/ void respuestaRecibo(@RequestBody Recibo recibo) {
        Recibo reciboConUltimaId = recibosRepo.findTopByOrderByIdDesc();
        recibo.setId(reciboConUltimaId.getId() + 1);
        recibosRepo.save(recibo);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(recibo.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//        return recibo;
    }

    @PostMapping(path = "/personas", consumes = "application/json", produces = "application/json")
    public /*ResponseEntity<Object>*/ /*Persona*/ void respuestaPersona(@RequestBody Persona persona) {
        Persona personaConUltimaId = personasRepo.findTopByOrderByIdDesc();
        persona.setId(personaConUltimaId.getId() + 1);
        personasRepo.save(persona);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(persona.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//        return persona;
    }

    @PostMapping(path = "/periodicidades", consumes = "application/json", produces = "application/json")
    public /*ResponseEntity<Object>*/ /*Periodicidad*/ void respuestaPeriodicidad(@RequestBody Periodicidad periodicidad) {
        Periodicidad periodicidadConUltimaId = periodicidadesRepo.findTopByOrderByIdDesc();
        periodicidad.setId(periodicidadConUltimaId.getId() + 1);
        periodicidadesRepo.save(periodicidad);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(periodicidad.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//        return periodicidad;
    }

    @PostMapping(path = "/plataformas", consumes = "application/json", produces = "application/json")
    public /*ResponseEntity<Object>*/ /*Plataforma*/ void respuestaPlataforma(@RequestBody Plataforma plataforma) {
        Plataforma plataformaConUltimaId = plataformasRepo.findTopByOrderByIdDesc();
        plataforma.setId(plataformaConUltimaId.getId() + 1);
        plataformasRepo.save(plataforma);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(plataforma.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//        return plataforma;
    }

    @PostMapping(path = "/formasdepago", consumes = "application/json", produces = "application/json")
    public /*ResponseEntity<Object>*/ /*FormaDePago*/ void respuestaFormaDePago(@RequestBody FormaDePago formaDePago) {
        FormaDePago formaDePagoConUltimaId = formasDePagoRepo.findTopByOrderByIdDesc();
        formaDePago.setId(formaDePagoConUltimaId.getId() + 1);
        formasDePagoRepo.save(formaDePago);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(formaDePago.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//        return formaDePago;
    }
    @PatchMapping(path ="/recibos", consumes = "application/json", produces = "application/json")
    public void actualizarRecibo(@RequestBody Recibo datosACambiarRecibo) {
        Recibo recibo = recibosRepo.findById(datosACambiarRecibo.getId()).orElse(null);
        if (recibo != null) {
            recibo.setReciboActivo(datosACambiarRecibo.isReciboActivo());
            recibo.setCobrado(datosACambiarRecibo.isCobrado());
            recibo.setFechaCobro(datosACambiarRecibo.getFechaCobro());
            recibo.setImporte(datosACambiarRecibo.getImporte());
            recibosRepo.save(recibo);
        }
    }
}

