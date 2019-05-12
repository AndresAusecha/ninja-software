package com.ninjaSoftware.prueba.logicaNegocio.controladores;

import com.ninjaSoftware.prueba.logicaNegocio.RequestBodies.NuevoTurno;
import com.ninjaSoftware.prueba.logicaNegocio.servicios.ServicioTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("logica-negocio/turno")
public class ControladorTurno {

    @Autowired
    private ServicioTurno servicioTurno;

    @PostMapping(produces = "application/json", path = "/crear")
    public ResponseEntity crearNuevoTurno(@RequestBody NuevoTurno nuevoTurno){
        return servicioTurno.insertar(nuevoTurno);
    }

    @GetMapping(produces = "application/json", path = "/leer/{id}")
    public ResponseEntity leerTurno(@PathVariable("id") Long idTurno){
        return servicioTurno.leer(idTurno);
    }

    @GetMapping(produces = "application/json", path = "/filtrar/fecha/{fechaEspecifica}")
    public ResponseEntity filtrarPorFechaEnEspeficico(@PathVariable("fechaEspecifica") String fechaEspecifica){
        return servicioTurno.filtrarPorFechaEspecifica(fechaEspecifica);
    }

    @GetMapping(produces = "application/json", path = "/filtrar/hora/{horaEspecifica}")
    public ResponseEntity filtrarPorHoraEnEspeficico(@PathVariable("horaEspecifica") String horaEspecifica){
        return servicioTurno.filtrarPorHoraEspecifica(horaEspecifica);
    }

    @GetMapping(produces = "application/json", path = "/filtrar/horaInicio/{horaInicio}")
    public ResponseEntity filtrarPorHoraInicio(@PathVariable("horaInicio") String horaInicio){
        return servicioTurno.filtrarPorHoraInicio(horaInicio);
    }

    @GetMapping(produces = "application/json", path = "/filtrar/horaFin/{horaFin}")
    public ResponseEntity filtrarPorHoraFin(@PathVariable("horaFin") String horaFin){
        return servicioTurno.filtrarPorHoraFin(horaFin);
    }

    @PutMapping(produces = "application/json", path = "/actualizar/{id}")
    public ResponseEntity actualizarTurno(
            @PathVariable("id") Long idTurno,
            @RequestBody NuevoTurno nuevoTurno
    ){
        return servicioTurno.actualizar(idTurno, nuevoTurno);
    }

    @DeleteMapping(produces = "application/json", path = "/eliminar/{id}")
    public ResponseEntity eliminarTurno(@PathVariable("id") Long idTurno){
        return servicioTurno.eliminar(idTurno);
    }

}
