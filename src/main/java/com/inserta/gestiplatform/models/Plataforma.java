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
@Table(name = "plataformas")
public class Plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String urlGeneral;
    private String urlAdmin;
    private String logo;
    private int limitePerfiles;
    private int limiteReproducciones;
    private String color;
    @JsonManagedReference
    @OneToMany(mappedBy = "plataforma")
    private List<Suscripcion> suscripciones;
}