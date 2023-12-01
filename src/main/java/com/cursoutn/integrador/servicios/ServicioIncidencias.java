package com.cursoutn.integrador.servicios;

import com.cursoutn.integrador.entidades.Incidencias;
import com.cursoutn.integrador.repositorios.IncidenciasRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioIncidencias implements ServicioBase<Incidencias>{
    private IncidenciasRepositorio repo;
    public ServicioIncidencias(IncidenciasRepositorio repo){
        this.repo = repo;
    }

    @Override
    @Transactional
    public List<Incidencias> seleccionarTodo() throws Exception {
        try {
            List<Incidencias> lista = repo.findAll();
            return lista;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Incidencias seleccionarUno(Long id) throws Exception {
        try {
            Optional<Incidencias> temp = repo.findById(id);
            return temp.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Incidencias guardar(Incidencias entidad) throws Exception {
        try{
            entidad = repo.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Incidencias actualizar(Incidencias entidad, Long id) throws Exception {
        try {
            Optional<Incidencias> capturo = repo.findById(id);
            Incidencias temp = capturo.get();
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
