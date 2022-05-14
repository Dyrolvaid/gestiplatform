package com.inserta.gestiplatform.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "periodicidad")
public class Periodicidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private String descripcion;
    @JsonManagedReference
    @OneToMany(mappedBy = "periodicidad")
    private List<Suscripcion> suscripciones;
}
