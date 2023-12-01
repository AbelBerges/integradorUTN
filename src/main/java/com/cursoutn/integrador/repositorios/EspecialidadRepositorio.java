package com.cursoutn.integrador.repositorios;

import com.cursoutn.integrador.entidades.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepositorio extends JpaRepository<Especialidad, Long> {
}
