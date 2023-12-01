package com.cursoutn.integrador.servicios;

import com.cursoutn.integrador.entidades.Calificacion;
import com.cursoutn.integrador.repositorios.CalificacionRepositorio;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.bcel.ExceptionRange;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCalificacion implements ServicioBase<Calificacion>{
    private CalificacionRepositorio repo;
    public ServicioCalificacion(CalificacionRepositorio repo){
        this.repo = repo;
    }

    @Override
    @Transactional
    public List<Calificacion> seleccionarTodo() throws Exception {
        try {
            List<Calificacion> lista = repo.findAll();
            return lista;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Calificacion seleccionarUno(Long id) throws Exception {
        try{
            Optional<Calificacion> capturo = repo.findById(id);
            return capturo.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Calificacion guardar(Calificacion laEnt) throws Exception {
        try {
            laEnt = repo.save(laEnt);
            return laEnt;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Calificacion actualizar(Calificacion laEntidad, Long id) throws Exception {
        try {
            Optional<Calificacion> capturo = repo.findById(id);
            Calificacion temp = capturo.get();
            temp = repo.save(laEntidad);
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
