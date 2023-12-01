package com.cursoutn.integrador.repositorios;

import com.cursoutn.integrador.entidades.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepositorio extends JpaRepository<Calificacion,Long> {
}
