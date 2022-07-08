package com.inserta.gestiplatform.models;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "periodicidad")
public class Periodicidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo;
    private String descripcion;
    /*
    @JsonIgnoreProperties("periodicidad")
    @OneToMany(mappedBy = "periodicidad")
    private List<Suscripcion> suscripciones;
    */

    public Periodicidad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Periodicidad that)) return false;
        return getId().equals(that.getId()) && getTipo().equals(that.getTipo()) && getDescripcion().equals(that.getDescripcion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTipo(), getDescripcion());
    }

    @Override
    public String toString() {
        return "Periodicidad{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
