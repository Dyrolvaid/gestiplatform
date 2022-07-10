package com.inserta.gestiplatform.models;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "suscripciones")
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@JsonIgnoreProperties("suscripciones") //No se porqué esto está aquí. Lo dejo por si acaso.
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
    private boolean suscripcionActiva;
    /*
    @JsonIgnoreProperties("suscripcion")
    @OneToMany(mappedBy = "suscripcion")
    private List<Grupo> grupos;
    */

    public Suscripcion() {
    }

    public Suscripcion(Integer id, Plataforma plataforma, Periodicidad periodicidad, FormaDePago formaDePago, String descripcion, LocalDate fechaAlta, LocalDate fechaProximoCobro, double precio, String credencialesCorreo, String credencialesClave, boolean suscripcionActiva) {
        this.id = id;
        this.plataforma = plataforma;
        this.periodicidad = periodicidad;
        this.formaDePago = formaDePago;
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
        this.fechaProximoCobro = fechaProximoCobro;
        this.precio = precio;
        this.credencialesCorreo = credencialesCorreo;
        this.credencialesClave = credencialesClave;
        this.suscripcionActiva = suscripcionActiva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaProximoCobro() {
        return fechaProximoCobro;
    }

    public void setFechaProximoCobro(LocalDate fechaProximoCobro) {
        this.fechaProximoCobro = fechaProximoCobro;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCredencialesCorreo() {
        return credencialesCorreo;
    }

    public void setCredencialesCorreo(String credencialesCorreo) {
        this.credencialesCorreo = credencialesCorreo;
    }

    public String getCredencialesClave() {
        return credencialesClave;
    }

    public void setCredencialesClave(String credencialesClave) {
        this.credencialesClave = credencialesClave;
    }

    public boolean isSuscripcionActiva() {
        return suscripcionActiva;
    }

    public void setSuscripcionActiva(boolean suscripcionActiva) {
        this.suscripcionActiva = suscripcionActiva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Suscripcion that)) return false;
        return Double.compare(that.getPrecio(), getPrecio()) == 0 && isSuscripcionActiva() == that.isSuscripcionActiva() && getId().equals(that.getId()) && getPlataforma().equals(that.getPlataforma()) && getPeriodicidad().equals(that.getPeriodicidad()) && getFormaDePago().equals(that.getFormaDePago()) && getDescripcion().equals(that.getDescripcion()) && getFechaAlta().equals(that.getFechaAlta()) && getFechaProximoCobro().equals(that.getFechaProximoCobro()) && getCredencialesCorreo().equals(that.getCredencialesCorreo()) && getCredencialesClave().equals(that.getCredencialesClave());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlataforma(), getPeriodicidad(), getFormaDePago(), getDescripcion(), getFechaAlta(), getFechaProximoCobro(), getPrecio(), getCredencialesCorreo(), getCredencialesClave(), isSuscripcionActiva());
    }

    @Override
    public String toString() {
        return "Suscripcion{" +
                "id=" + id +
                ", plataforma=" + plataforma +
                ", periodicidad=" + periodicidad +
                ", formaDePago=" + formaDePago +
                ", descripcion='" + descripcion + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", fechaProximoCobro=" + fechaProximoCobro +
                ", precio=" + precio +
                ", credencialesCorreo='" + credencialesCorreo + '\'' +
                ", credencialesClave='" + credencialesClave + '\'' +
                ", suscripcionActiva=" + suscripcionActiva +
                '}';
    }
}
