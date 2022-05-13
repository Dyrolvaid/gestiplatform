package com.inserta.gestiplatform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plataformas")
public class Plataforma {
    //Atributos
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
}