package com.inserta.gestiplatform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "suscripciones")
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_plataforma", referencedColumnName = "id")
    private Plataforma plataforma;
    @ManyToOne
    @JoinColumn(name = "id_periodicidad", referencedColumnName = "id")
    private Periodicidad periodicidad;
    @ManyToOne
    @JoinColumn(name = "id_forma_de_pago", referencedColumnName = "id")
    private FormaDePago formaDePago;
    private String descripcion;
    private LocalDate fechaAlta;
    private LocalDate fechaProximoCobro;
    private double precio;
    private String credencialesCorreo;
    private String credencialesClave;
}
