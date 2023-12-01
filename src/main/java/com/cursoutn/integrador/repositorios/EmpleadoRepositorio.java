package com.cursoutn.integrador.repositorios;

import com.cursoutn.integrador.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado,Long> {
}
