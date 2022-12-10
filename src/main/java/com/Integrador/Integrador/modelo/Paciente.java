package com.Integrador.Integrador.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

    @Column
    private String apellido;

    private String nombre;

    @Column
    private String dni;

    @Column
    private LocalDate fechaIngreso;

    @Column
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    public Paciente() {
    }


    public Paciente(Long id, String apellido, String nombre, String dni, LocalDate fechaIngreso, String email, Domicilio domicilio) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
        this.domicilio = domicilio;
    }

    public Paciente(String apellido, String nombre, String dni, LocalDate fechaIngreso, String email, Domicilio domicilio) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", domicilio=" + domicilio +

                '}';
    }

}
