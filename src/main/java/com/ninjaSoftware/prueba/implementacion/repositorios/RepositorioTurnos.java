package com.ninjaSoftware.prueba.implementacion.repositorios;

import com.ninjaSoftware.prueba.implementacion.modelos.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface RepositorioTurnos extends JpaRepository<Turno, Long> {
    @Query("SELECT t FROM Turno t where :diaTurno >= t.fechaInicio AND :diaTurno <= t.fechaFin")
    List<Turno> findTurnoXFechaEspecifica(@Param("diaTurno") Date diaTurno);

    @Query("SELECT t FROM Turno t WHERE :horaTurno BETWEEN t.horaInicio AND t.horaFin")
    List<Turno> findTurnoXHoraEspecifica(@Param("horaTurno") Time horaTurno);

    @Query("SELECT t FROM Turno t WHERE TIME_FORMAT(:horaInicio, '%H:00:00') = TIME_FORMAT(t.horaInicio, '%H:00:00')")
    List<Turno> findTurnoXHoraDeInicio(@Param("horaInicio") Time horaInicio);

    @Query("SELECT t FROM Turno t WHERE TIME_FORMAT(:horaFin, '%H:00:00') = TIME_FORMAT(t.horaFin, '%H:00:00')")
    List<Turno> findTurnoXHoraDeFin(@Param("horaFin") Time horaFin);
}
