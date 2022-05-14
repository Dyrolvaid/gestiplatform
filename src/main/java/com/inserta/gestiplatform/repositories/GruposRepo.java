package com.inserta.gestiplatform.repositories;

import com.inserta.gestiplatform.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "grupos")
public interface GruposRepo extends JpaRepository <Grupo, Integer>{
}
