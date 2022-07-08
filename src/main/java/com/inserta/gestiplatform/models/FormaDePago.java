package com.inserta.gestiplatform.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "formas_pago")
public class FormaDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private boolean favorita;
    /*
    @JsonIgnoreProperties("formaDePago")
    @OneToMany(mappedBy = "formaDePago")
    private List<Suscripcion> suscripciones;
    */

    public FormaDePago() {
    }

    public FormaDePago(Integer id, String descripcion, boolean favorita) {
        this.id = id;
        this.descripcion = descripcion;
        this.favorita = favorita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormaDePago that)) return false;
        return isFavorita() == that.isFavorita() && Objects.equals(getId(), that.getId()) && Objects.equals(getDescripcion(), that.getDescripcion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescripcion(), isFavorita());
    }

    @Override
    public String toString() {
        return "FormaDePago{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", favorita=" + favorita +
                '}';
    }
}

