package com.cursoutn.integrador.repositorios;

import com.cursoutn.integrador.entidades.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepositorio extends JpaRepository<Tecnico, Long> {
}
