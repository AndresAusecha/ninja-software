package com.ninjaSoftware.prueba.implementacion.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Empleado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Empleado(){
        this.turnos = new HashSet<>();
    }

    public Empleado(@NotNull Long numeroIdentificacion, @NotBlank String nombre, @NotBlank String apellido) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.turnos = new HashSet<>();
    }

    @NotNull @Column(unique = true)
    private Long numeroIdentificacion;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @ManyToMany
    @JoinTable(name = "empleado_turno",
        joinColumns = @JoinColumn(name = "empleado_id"),
        inverseJoinColumns = @JoinColumn(name = "turno_id")
    )
    @JsonManagedReference
    private Set<Turno> turnos;

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurno(Turno turno) {
        this.turnos.add(turno);
    }

    public Long getId() {
        return id;
    }

    public Long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(Long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
