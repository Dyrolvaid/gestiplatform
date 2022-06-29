package com.inserta.gestiplatform.repositories;

import com.inserta.gestiplatform.models.Grupo;
import com.inserta.gestiplatform.models.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "recibos", collectionResourceRel = "recibos")
public interface RecibosRepo extends JpaRepository<Recibo, Integer> {
    List<Recibo> findByGrupo(Grupo grupo);
}
