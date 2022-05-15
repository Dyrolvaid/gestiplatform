package com.inserta.gestiplatform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
//    @JsonIgnoreProperties("periodicidad")
//    @OneToMany(mappedBy = "periodicidad")
//    private List<Suscripcion> suscripciones;
}
