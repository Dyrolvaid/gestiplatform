package com.inserta.gestiplatform.repositories;

import com.inserta.gestiplatform.models.Grupo;
import com.inserta.gestiplatform.models.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "plataformas", collectionResourceRel = "plataformas")
public interface PlataformasRepo extends JpaRepository<Plataforma, Integer> {
    Plataforma findTopByOrderByIdDesc();
}

