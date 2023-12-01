package com.cursoutn.integrador.repositorios;

import com.cursoutn.integrador.entidades.Incidencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenciasRepositorio extends JpaRepository<Incidencias,Long> {
}
