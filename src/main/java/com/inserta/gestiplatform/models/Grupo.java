package com.inserta.gestiplatform.models;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


@Entity
@Table(name = "grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*
    @JsonIgnoreProperties("grupos")
    */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_persona",referencedColumnName = "id")
    private Persona persona;
    /*
    @JsonIgnoreProperties("grupos")
    */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_suscripcion",referencedColumnName = "id")
    private Suscripcion suscripcion;


    private boolean grupoActivo;

    private boolean admin;
    /*
    @JsonIgnoreProperties("grupo")
    @OneToMany(mappedBy = "grupo")
    private List<Recibo> recibos;
    */

    public Grupo() {
    }

    public Grupo(Integer id, Persona persona, Suscripcion suscripcion, boolean grupoActivo, boolean admin) {
        this.id = id;
        this.persona = persona;
        this.suscripcion = suscripcion;
        this.grupoActivo = grupoActivo;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public boolean isGrupoActivo() {
        return grupoActivo;
    }

    public void setGrupoActivo(boolean grupoActivo) {
        this.grupoActivo = grupoActivo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grupo grupo)) return false;
        return isGrupoActivo() == grupo.isGrupoActivo() && isAdmin() == grupo.isAdmin() && getId().equals(grupo.getId()) && getPersona().equals(grupo.getPersona()) && getSuscripcion().equals(grupo.getSuscripcion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPersona(), getSuscripcion(), isGrupoActivo(), isAdmin());
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", persona=" + persona +
                ", suscripcion=" + suscripcion +
                ", grupoActivo=" + grupoActivo +
                ", admin=" + admin +
                '}';
    }
}
