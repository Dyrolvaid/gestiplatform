package com.inserta.gestiplatform.repositories;

import com.inserta.gestiplatform.models.Grupo;
import com.inserta.gestiplatform.models.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "grupos", collectionResourceRel = "grupos")
public interface GruposRepo extends JpaRepository <Grupo, Integer>{

    List<Grupo> findByPersonaId(Integer id);
    List<Grupo> findBySuscripcion(Suscripcion suscripcion);

    Grupo findTopByOrderByIdDesc();


//    Grupo deleteByPersona(Persona persona);
//    Grupo findByPersona(Persona persona);
}
