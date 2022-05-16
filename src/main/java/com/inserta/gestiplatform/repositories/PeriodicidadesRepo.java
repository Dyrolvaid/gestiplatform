package com.inserta.gestiplatform.repositories;

import com.inserta.gestiplatform.models.Periodicidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "periodicidades", collectionResourceRel = "periodicidades")
public interface PeriodicidadesRepo extends JpaRepository<Periodicidad, Integer> {
}
