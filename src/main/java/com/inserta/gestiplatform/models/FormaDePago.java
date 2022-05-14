package com.inserta.gestiplatform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formas_pago")
public class FormaDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private boolean favorita;
    @OneToMany(mappedBy = "formaDePago")
    private List<Suscripcion> suscripciones;
}
