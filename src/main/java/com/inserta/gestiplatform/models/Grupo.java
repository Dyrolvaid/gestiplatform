package com.inserta.gestiplatform.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("grupos")
    @ManyToOne
    @JoinColumn(name = "id_persona",referencedColumnName = "id")
    private Persona persona;
    @JsonIgnoreProperties("grupos")
    @ManyToOne
    @JoinColumn(name = "id_suscripcion",referencedColumnName = "id")
    private Suscripcion suscripcion;
    @JsonIgnoreProperties("grupo")
    @OneToMany(mappedBy = "grupo")
    private List<Recibo> recibos;
}
