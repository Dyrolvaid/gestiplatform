package com.inserta.gestiplatform.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_persona",referencedColumnName = "id")
    private Persona persona;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_suscripcion",referencedColumnName = "id")
    private Suscripcion suscripcion;
    @JsonManagedReference
    @OneToMany(mappedBy = "grupo")
    private List<Recibo> recibos;
}
