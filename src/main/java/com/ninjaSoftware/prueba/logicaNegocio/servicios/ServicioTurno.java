package com.ninjaSoftware.prueba.logicaNegocio.servicios;

import com.ninjaSoftware.prueba.logicaNegocio.RequestBodies.NuevoTurno;
import org.springframework.http.ResponseEntity;

public interface ServicioTurno {
    ResponseEntity insertar(NuevoTurno NuevoTurno);

    ResponseEntity actualizar(Long id, NuevoTurno NuevoTurno);

    ResponseEntity leer(Long id);

    ResponseEntity eliminar(Long id);

    ResponseEntity filtrarPorFechaEspecifica(String fechaEnEspecifico);

    ResponseEntity filtrarPorHoraEspecifica(String horaEspecifica);

    ResponseEntity filtrarPorHoraInicio(String horaEspecifica);

    ResponseEntity filtrarPorHoraFin(String horaEspecifica);
}
