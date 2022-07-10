package com.inserta.gestiplatform.models;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String correo;
    private String nombre;
    private String clave;
    private String telefono;

    /*
    @JsonIgnoreProperties("persona")
    @OneToMany(mappedBy = "persona")
    private List<Grupo> grupos;
    */

    public Persona() {
    }

    public Persona(Integer id, String correo, String nombre, String clave, String telefono) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.clave = clave;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return getId().equals(persona.getId()) && getCorreo().equals(persona.getCorreo()) && getNombre().equals(persona.getNombre()) && getClave().equals(persona.getClave()) && getTelefono().equals(persona.getTelefono());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCorreo(), getNombre(), getClave(), getTelefono());
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
