package com.cursoutn.integrador.servicios;

import com.cursoutn.integrador.entidades.Estado;
import com.cursoutn.integrador.repositorios.EstadoRepositorio;
import com.zaxxer.hikari.SQLExceptionOverride;
import jakarta.transaction.Transactional;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEstado implements ServicioBase<Estado>{
    private EstadoRepositorio repo;
    public ServicioEstado(EstadoRepositorio repo){
        this.repo = repo;
    }

    @Override
    @Transactional
    public List<Estado> seleccionarTodo() throws Exception {
        try {
            List<Estado> lista = repo.findAll();
            return lista;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estado seleccionarUno(Long id) throws Exception {
        try {
            Optional<Estado> capturo = repo.findById(id);
            return capturo.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estado guardar(Estado entidad) throws Exception {
        try {
            entidad = repo.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estado actualizar(Estado entidad, Long id) throws Exception {
        try {
            Optional<Estado> tomo = repo.findById(id);
            Estado temp = tomo.get();
            temp = repo.save(entidad);
            return temp;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean borrar(Long id) throws Exception {
        try {
            if(repo.existsById(id)){
                repo.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
