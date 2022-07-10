package com.inserta.gestiplatform.models;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "recibos")
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @JsonIgnoreProperties("recibos")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_grupo", referencedColumnName = "id")
    private Grupo grupo;

    private LocalDate fechaEmision;
    private LocalDate fechaCobro;
    private LocalDate vigenciaInicio;
    private LocalDate vigenciaFin;
    private boolean cobrado;
    private double importe;
    private boolean reciboActivo;

    public Recibo() {
    }

    public Recibo(Integer id, Grupo grupo, LocalDate fechaEmision, LocalDate fechaCobro, LocalDate vigenciaInicio, LocalDate vigenciaFin, boolean cobrado, double importe, boolean reciboActivo) {
        this.id = id;
        this.grupo = grupo;
        this.fechaEmision = fechaEmision;
        this.fechaCobro = fechaCobro;
        this.vigenciaInicio = vigenciaInicio;
        this.vigenciaFin = vigenciaFin;
        this.cobrado = cobrado;
        this.importe = importe;
        this.reciboActivo = reciboActivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(LocalDate fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public LocalDate getVigenciaInicio() {
        return vigenciaInicio;
    }

    public void setVigenciaInicio(LocalDate vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    public LocalDate getVigenciaFin() {
        return vigenciaFin;
    }

    public void setVigenciaFin(LocalDate vigenciaFin) {
        this.vigenciaFin = vigenciaFin;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isReciboActivo() {
        return reciboActivo;
    }

    public void setReciboActivo(boolean reciboActivo) {
        this.reciboActivo = reciboActivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recibo recibo)) return false;
        return isCobrado() == recibo.isCobrado() && Double.compare(recibo.getImporte(), getImporte()) == 0 && isReciboActivo() == recibo.isReciboActivo() && getId().equals(recibo.getId()) && getGrupo().equals(recibo.getGrupo()) && getFechaEmision().equals(recibo.getFechaEmision()) && getFechaCobro().equals(recibo.getFechaCobro()) && getVigenciaInicio().equals(recibo.getVigenciaInicio()) && getVigenciaFin().equals(recibo.getVigenciaFin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGrupo(), getFechaEmision(), getFechaCobro(), getVigenciaInicio(), getVigenciaFin(), isCobrado(), getImporte(), isReciboActivo());
    }

    @Override
    public String toString() {
        return "Recibo{" +
                "id=" + id +
                ", grupo=" + grupo +
                ", fechaEmision=" + fechaEmision +
                ", fechaCobro=" + fechaCobro +
                ", vigenciaInicio=" + vigenciaInicio +
                ", vigenciaFin=" + vigenciaFin +
                ", cobrado=" + cobrado +
                ", importe=" + importe +
                ", reciboActivo=" + reciboActivo +
                '}';
    }
}
