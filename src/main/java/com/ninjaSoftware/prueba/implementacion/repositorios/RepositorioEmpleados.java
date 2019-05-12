package com.ninjaSoftware.prueba.implementacion.repositorios;

import com.ninjaSoftware.prueba.implementacion.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioEmpleados extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByNumeroIdentificacion(Long numeroIdentificacion);
}
