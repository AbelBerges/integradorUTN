package com.cursoutn.integrador.servicios;

import com.cursoutn.integrador.entidades.Especialidad;
import com.cursoutn.integrador.repositorios.EspecialidadRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ServicioEspecialidad implements ServicioBase<Especialidad>{
    private EspecialidadRepositorio especial;

    public ServicioEspecialidad(EspecialidadRepositorio especial){
        this.especial = especial;
    }

    @Override
    @Transactional
    public List<Especialidad> seleccionarTodo() throws Exception {
        try{
            List<Especialidad> lista = especial.findAll();
            return lista;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Especialidad seleccionarUno(Long id) throws Exception {
        try {
            Optional<Especialidad> traigo = especial.findById(id);
            return traigo.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Especialidad guardar(Especialidad entidad) throws Exception {
        try {
            entidad = especial.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Especialidad actualizar(Especialidad entidad, Long id) throws Exception {
        try {
            Optional<Especialidad> tomo = especial.findById(id);
            Especialidad temp = tomo.get();
            temp = especial.save(entidad);
            return temp;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean borrar(Long id) throws Exception {
        try {
            if(especial.existsById(id)){
                especial.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
