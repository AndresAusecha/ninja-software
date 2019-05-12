package com.ninjaSoftware.prueba.logicaNegocio.RequestBodies;

public class NuevoEmpleado {
    private String nombre;
    private String apellido;
    private Long numeroIdentificacion;

    public NuevoEmpleado(){

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

    public Long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(Long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
}
