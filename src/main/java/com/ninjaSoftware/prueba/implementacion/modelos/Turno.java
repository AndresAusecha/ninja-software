package com.ninjaSoftware.prueba.implementacion.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Turno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private Date fechaInicio;

    @Basic(optional = false)
    private Date fechaFin;

    @Basic(optional = false)
    private Time horaInicio;

    @Basic(optional = false)
    private Time horaFin;

    @ManyToMany(mappedBy = "turnos") @JsonBackReference
    private Set<Empleado> empleados;

    public Turno(){
        this.empleados = new HashSet<>();
    }

    public Turno(Date fechaInicio, Date fechaFin, Time horaInicio, Time horaFin){
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.empleados = new HashSet<>();
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado emp) {
        this.empleados.add(emp);
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public Long getId() {
        return id;
    }
}
