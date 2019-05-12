package com.ninjaSoftware.prueba.logicaNegocio.servicios;

import com.ninjaSoftware.prueba.logicaNegocio.RequestBodies.NuevoEmpleado;
import org.springframework.http.ResponseEntity;

public interface ServicioEmpleado {

    ResponseEntity insertar(NuevoEmpleado nuevoEmpleado);

    ResponseEntity actualizar(Long id, NuevoEmpleado nuevoEmpleado);

    ResponseEntity leer(Long id);

    ResponseEntity eliminar(Long id);

    ResponseEntity listar();

    ResponseEntity asignarTurnoAEmpleado(Long idEmpleado, Long idTurno);

    ResponseEntity consultarPorNumeroIdentificacion(Long idEmpleado);
}
