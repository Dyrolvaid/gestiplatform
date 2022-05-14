package com.inserta.gestiplatform.repositories;

import com.inserta.gestiplatform.models.FormaDePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "formasdepago")
public interface FormasDePagoRepo extends JpaRepository<FormaDePago, Integer> {
}
