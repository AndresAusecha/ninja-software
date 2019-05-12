package com.ninjaSoftware.prueba.logicaNegocio.servicios.impl;

import com.ninjaSoftware.prueba.implementacion.modelos.Empleado;
import com.ninjaSoftware.prueba.implementacion.modelos.Turno;
import com.ninjaSoftware.prueba.implementacion.repositorios.RepositorioEmpleados;
import com.ninjaSoftware.prueba.implementacion.repositorios.RepositorioTurnos;
import com.ninjaSoftware.prueba.logicaNegocio.RequestBodies.NuevoEmpleado;
import com.ninjaSoftware.prueba.logicaNegocio.servicios.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioEmpleadoImpl implements ServicioEmpleado {

    @Autowired
    private RepositorioEmpleados repo;

    @Autowired
    private RepositorioTurnos repositorioTurnos;

    @Override
    public ResponseEntity insertar(NuevoEmpleado nuevoEmpleado) {
        Empleado empleado = repo.save(new Empleado(
                nuevoEmpleado.getNumeroIdentificacion(),
                nuevoEmpleado.getNombre(),
                nuevoEmpleado.getApellido()
        ));

        return new ResponseEntity<>(empleado, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity actualizar(Long id, NuevoEmpleado nuevoEmpleado) {
        Optional<Empleado> opt = repo.findById(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>("{ \"Error\": \"No hay un empleado con ese id\" }", HttpStatus.NOT_FOUND);
        }
        Empleado empleado = opt.get();
        empleado.setNumeroIdentificacion(nuevoEmpleado.getNumeroIdentificacion());
        empleado.setNombre(nuevoEmpleado.getNombre());
        empleado.setApellido(nuevoEmpleado.getApellido());
        repo.save(empleado);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @Override
    public ResponseEntity leer(Long id) {
        Optional<Empleado> opt = repo.findById(id);
        return opt.isPresent() ? new ResponseEntity<>(opt.get(), HttpStatus.FOUND):
                new ResponseEntity<>("{ \"Error\": \"No hay un empleado con ese id\" }", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity eliminar(Long id) {
        Optional<Empleado> opt = repo.findById(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>("{ \"Error\": \"No hay un empleado con ese id\" }", HttpStatus.NOT_FOUND);
        }
        repo.deleteById(opt.get().getId());

        return new ResponseEntity<>(
                "{ \"mensaje\": \"Empleado con id: " + id + " ha sido eliminado\" }",
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity listar() {
        return new ResponseEntity<>(repo.findAll(Sort.by("apellido")), HttpStatus.OK);
    }

    @Override
    public ResponseEntity asignarTurnoAEmpleado(Long idEmpleado, Long idTurno) {
        Optional<Empleado> opt = repo.findById(idEmpleado);
        if(!opt.isPresent()){
            return new ResponseEntity<>("{ \"Error\": \"No hay un empleado con ese id\" }", HttpStatus.NOT_FOUND);
        }
        Optional<Turno> optTurno = repositorioTurnos.findById(idTurno);
        if(!optTurno.isPresent()){
            return new ResponseEntity<>("{ \"Error\": \"No hay un turno con ese id\" }", HttpStatus.NOT_FOUND);
        }
        Empleado emp = opt.get();
        emp.setTurno(optTurno.get());

        return new ResponseEntity<>(
            repo.save(emp),
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity consultarPorNumeroIdentificacion(Long idEmpleado) {
        Optional<Empleado> opt = repo.findByNumeroIdentificacion(idEmpleado);
        return opt.isPresent() ? new ResponseEntity<>(opt.get(), HttpStatus.OK)
            : new ResponseEntity<>(
                "{ \"Error\": \"No hay un empleado con ese numero de identificacion\" }",
                HttpStatus.NOT_FOUND
        );
    }

}
