package com.inserta.gestiplatform.repositories;

import com.inserta.gestiplatform.models.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "suscripciones", collectionResourceRel = "suscripciones")
public interface SuscripcionesRepo extends JpaRepository<Suscripcion, Integer> {
}
