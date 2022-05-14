package com.inserta.gestiplatform.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recibos")
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id")
    private Grupo grupo;
    private LocalDate fechaEmision;
    private LocalDate fechaCobro;
    private LocalDate vigenciaInicio;
    private LocalDate vigenciaFin;
    private boolean cobrado;
    private double importe;
}
