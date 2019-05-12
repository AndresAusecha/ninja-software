package com.ninjaSoftware.prueba.logicaNegocio.servicios.impl;

import com.ninjaSoftware.prueba.implementacion.modelos.Turno;
import com.ninjaSoftware.prueba.implementacion.repositorios.RepositorioTurnos;
import com.ninjaSoftware.prueba.logicaNegocio.RequestBodies.NuevoTurno;
import com.ninjaSoftware.prueba.logicaNegocio.servicios.ServicioTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioTurnoImpl implements ServicioTurno {

    @Autowired
    private RepositorioTurnos repo;

    private java.util.Date fechaActual;

    public ServicioTurnoImpl(){
        fechaActual = new java.util.Date();
    }

    @Override
    public ResponseEntity insertar(NuevoTurno nuevoTurno) {
        Date fechaInicio = Date.valueOf(nuevoTurno.getFechaInicio());
        Date fechaFin = Date.valueOf(nuevoTurno.getFechaFin());
        Time horaInicio = Time.valueOf(nuevoTurno.getHoraInicio());
        Time horaFin = Time.valueOf(nuevoTurno.getHoraFin());
        if(fechaInicio.before(fechaActual) || fechaFin.before(fechaInicio) || horaFin.before(horaInicio)){
            return new ResponseEntity<>(
                    "{ \"Error\": \"Fecha u hora invalidas\" }",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
            repo.save(
                    new Turno(
                    fechaInicio,
                    fechaFin,
                    horaInicio,
                    horaFin
                )),
            HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity actualizar(Long id, NuevoTurno nuevoTurno) {
        Optional<Turno> opt = repo.findById(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>("{ \"Error\": \"No hay un turno con ese id\" }", HttpStatus.NOT_FOUND);
        }
        Turno turno = opt.get();
        Date fechaInicio = Date.valueOf(nuevoTurno.getFechaInicio());
        Date fechaFin = Date.valueOf(nuevoTurno.getFechaFin());
        Time horaInicio = Time.valueOf(nuevoTurno.getHoraInicio());
        Time horaFin = Time.valueOf(nuevoTurno.getHoraFin());
        if(fechaInicio.before(fechaActual) || fechaFin.before(fechaInicio) || horaFin.before(horaInicio)){
            return new ResponseEntity<>(
                    "{ \"Error\": \"Fecha u hora inválidas\" }",
                    HttpStatus.BAD_REQUEST
            );
        }
        turno.setFechaInicio(fechaInicio);
        turno.setFechaFin(fechaFin);
        turno.setHoraInicio(horaInicio);
        turno.setHoraFin(horaFin);
        return new ResponseEntity<>(repo.save(turno), HttpStatus.OK);
    }

    @Override
    public ResponseEntity leer(Long id) {
        Optional<Turno> opt = repo.findById(id);
        return opt.isPresent() ? new ResponseEntity<>(opt.get(), HttpStatus.FOUND):
                new ResponseEntity<>("{ \"Error\": \"No hay un turno con ese id\" }", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity eliminar(Long id) {
        Optional<Turno> opt = repo.findById(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>("{ \"Error\": \"No hay un turno con ese id\" }", HttpStatus.NOT_FOUND);
        }
        repo.deleteById(opt.get().getId());

        return new ResponseEntity<>(
                "{ \"mensaje\": \"Turno con id: " + id + " ha sido eliminado\" }",
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity filtrarPorFechaEspecifica(String fechaEnEspecifico) {
        try {
            List<Turno> lista = repo.findTurnoXFechaEspecifica(Date.valueOf(fechaEnEspecifico));
            if(lista.isEmpty()){
                return new ResponseEntity<>(
                        "{ \"mensaje\": \"No se ha hallado un turno\"}",
                        HttpStatus.NOT_FOUND
                );
            }
            return new ResponseEntity<>(
                    lista, HttpStatus.OK
            );
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(
                    "{\"mensaje\": \"Formato de fecha invalido\"}", HttpStatus.BAD_REQUEST
            );
        }
    }

    @Override
    public ResponseEntity filtrarPorHoraEspecifica(String horaEspecifica) {
        List<Turno> lista = repo.findTurnoXHoraEspecifica(Time.valueOf(horaEspecifica));
        if(lista.isEmpty()){
            return new ResponseEntity<>(
                    "{ \"mensaje\": \"No se ha hallado un turno\"}",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                lista, HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity filtrarPorHoraInicio(String horaEspecifica) {
        List<Turno> lista = repo.findTurnoXHoraDeInicio(Time.valueOf(horaEspecifica));
        if(lista.isEmpty()){
            return new ResponseEntity<>(
                    "{ \"mensaje\": \"No se ha hallado un turno\"}",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                lista, HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity filtrarPorHoraFin(String horaEspecifica) {
        List<Turno> lista = repo.findTurnoXHoraDeFin(Time.valueOf(horaEspecifica));
        if(lista.isEmpty()){
            return new ResponseEntity<>(
                    "{ \"mensaje\": \"No se ha hallado un turno\"}",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                lista, HttpStatus.OK
        );
    }

}
