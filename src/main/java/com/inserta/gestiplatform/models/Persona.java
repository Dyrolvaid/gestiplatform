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
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String correo;
    private String nombre;
    private String clave;
    private String telefono;
    private boolean admin;
    @JsonManagedReference
    @OneToMany(mappedBy = "persona")
    private List<Grupo> grupos;
}
