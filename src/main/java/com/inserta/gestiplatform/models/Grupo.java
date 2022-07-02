package com.inserta.gestiplatform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*
    @JsonIgnoreProperties("grupos")
    */
    @ManyToOne
    @JoinColumn(name = "id_persona",referencedColumnName = "id")
    private Persona persona;
    /*
    @JsonIgnoreProperties("grupos")
    */
    @ManyToOne
    @JoinColumn(name = "id_suscripcion",referencedColumnName = "id")
    private Suscripcion suscripcion;

    private boolean grupoActivo;
    /*
    @JsonIgnoreProperties("grupo")
    @OneToMany(mappedBy = "grupo")
    private List<Recibo> recibos;
    */
}
