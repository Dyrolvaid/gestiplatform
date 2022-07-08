package com.inserta.gestiplatform.models;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "plataformas")
public class Plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String urlGeneral;
    private String urlAdmin;
    private String logo;
    private int limitePerfiles;
    private int limiteReproducciones;
    private String color;
    /*
    @JsonIgnoreProperties("plataforma")
    @OneToMany(mappedBy = "plataforma")
    private List<Suscripcion> suscripciones;
    */

    public Plataforma() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlGeneral() {
        return urlGeneral;
    }

    public void setUrlGeneral(String urlGeneral) {
        this.urlGeneral = urlGeneral;
    }

    public String getUrlAdmin() {
        return urlAdmin;
    }

    public void setUrlAdmin(String urlAdmin) {
        this.urlAdmin = urlAdmin;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getLimitePerfiles() {
        return limitePerfiles;
    }

    public void setLimitePerfiles(int limitePerfiles) {
        this.limitePerfiles = limitePerfiles;
    }

    public int getLimiteReproducciones() {
        return limiteReproducciones;
    }

    public void setLimiteReproducciones(int limiteReproducciones) {
        this.limiteReproducciones = limiteReproducciones;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plataforma that)) return false;
        return getLimitePerfiles() == that.getLimitePerfiles() && getLimiteReproducciones() == that.getLimiteReproducciones() && getId().equals(that.getId()) && getNombre().equals(that.getNombre()) && getUrlGeneral().equals(that.getUrlGeneral()) && getUrlAdmin().equals(that.getUrlAdmin()) && getLogo().equals(that.getLogo()) && getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getUrlGeneral(), getUrlAdmin(), getLogo(), getLimitePerfiles(), getLimiteReproducciones(), getColor());
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", urlGeneral='" + urlGeneral + '\'' +
                ", urlAdmin='" + urlAdmin + '\'' +
                ", logo='" + logo + '\'' +
                ", limitePerfiles=" + limitePerfiles +
                ", limiteReproducciones=" + limiteReproducciones +
                ", color='" + color + '\'' +
                '}';
    }
}