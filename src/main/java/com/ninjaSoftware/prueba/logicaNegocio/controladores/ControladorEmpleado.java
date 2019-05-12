package com.ninjaSoftware.prueba.logicaNegocio.controladores;

import com.ninjaSoftware.prueba.logicaNegocio.RequestBodies.NuevoEmpleado;
import com.ninjaSoftware.prueba.logicaNegocio.servicios.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("logica-negocio/empleado")
public class ControladorEmpleado {

    @Autowired
    private ServicioEmpleado servicioEmpleado;

    @PostMapping(produces = "application/json", path = "/crear")
    public ResponseEntity crearNuevoEmpleado(@RequestBody NuevoEmpleado nuevoEmpleado){
        return servicioEmpleado.insertar(nuevoEmpleado);
    }

    @GetMapping(produces = "application/json", path = "/leer/{id}")
    public ResponseEntity leerEmpleado(@PathVariable("id") Long idEmpleado){
        return servicioEmpleado.leer(idEmpleado);
    }

    @GetMapping(produces = "application/json", path = "/listar-ordenando-x-apellido")
    public ResponseEntity listarEmpleado(){
        return servicioEmpleado.listar();
    }

    @GetMapping(produces = "application/json", path = "/buscar/idEmpleado/{idEmpleado}")
    public ResponseEntity buscarEmpleadoPorNumeroDeIdentificacion(@PathVariable("idEmpleado") Long idEmpleado){
        return servicioEmpleado.consultarPorNumeroIdentificacion(idEmpleado);
    }

    @PutMapping(produces = "application/json", path = "/actualizar/{id}")
    public ResponseEntity actualizarEmpleado(
            @PathVariable("id") Long idEmpleado,
            @RequestBody NuevoEmpleado nuevoEmpleado
    ){
        return servicioEmpleado.actualizar(idEmpleado, nuevoEmpleado);
    }

    @DeleteMapping(produces = "application/json", path = "/eliminar/{id}")
    public ResponseEntity eliminarEmpleado(@PathVariable("id") Long idEmpleado){
        return servicioEmpleado.eliminar(idEmpleado);
    }

    @PutMapping(
        produces = "application/json",
        path = "/asignar-turno-a-empleado/id-empleado/{idEmpleado}/id-turno/{idTurno}"
    )
    public ResponseEntity asignarTurnoAEmpleado(
            @PathVariable("idEmpleado") Long idEmpleado,
            @PathVariable("idTurno") Long idTurno
    ){
        return servicioEmpleado.asignarTurnoAEmpleado(idEmpleado, idTurno);
    }

}
