package com.inserta.gestiplatform.repositories;

import com.inserta.gestiplatform.models.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "plataformas")
public interface PlataformasRepo extends JpaRepository<Plataforma, Integer> {
}

