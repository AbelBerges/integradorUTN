package com.cursoutn.integrador.servicios;

import com.cursoutn.integrador.entidades.Tecnico;
import com.cursoutn.integrador.repositorios.TecnicoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioTecnico implements ServicioBase<Tecnico>{
    private TecnicoRepositorio tec;

    public ServicioTecnico(TecnicoRepositorio tec){
        this.tec = tec;
    }

    @Override
    @Transactional
    public List seleccionarTodo() throws Exception {
        try{
            List<Tecnico> lista = tec.findAll();
            return lista;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Tecnico seleccionarUno(Long id) throws Exception {
        try{
            Optional<Tecnico> elTecnico = tec.findById(id);
            return elTecnico.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Tecnico guardar(Tecnico entidad) throws Exception {
        try{
            entidad = tec.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Tecnico actualizar(Tecnico entidad, Long id) throws Exception {
        try{
            Optional<Tecnico> capturo = tec.findById(id);
            Tecnico temp = capturo.get();
            temp = tec.save(entidad);
            return temp;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean borrar(Long id) throws Exception {
        try{
            if(tec.existsById(id)){
                tec.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
