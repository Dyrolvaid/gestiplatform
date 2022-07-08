package com.inserta.gestiplatform.repositories;

import com.inserta.gestiplatform.models.Grupo;
import com.inserta.gestiplatform.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "personas", collectionResourceRel = "personas")
public interface PersonasRepo extends JpaRepository<Persona, Integer> {
    Persona findByCorreoAndClave(String correo, String clave);
    Persona findByCorreo(String correo);

    Persona findTopByOrderByIdDesc();
}
