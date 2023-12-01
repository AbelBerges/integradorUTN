package com.cursoutn.integrador.servicios;

import com.cursoutn.integrador.entidades.Empleado;
import com.cursoutn.integrador.repositorios.EmpleadoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEmpleado implements ServicioBase<Empleado> {
    private EmpleadoRepositorio emp;

    public ServicioEmpleado(EmpleadoRepositorio emp){
        this.emp = emp;
    }

    @Override
    @Transactional
    public List seleccionarTodo() throws Exception {
        try {
            List<Empleado> lista = emp.findAll();
            return lista;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Empleado seleccionarUno(Long id) throws Exception {
        try{
            Optional<Empleado> temp = emp.findById(id);
            return temp.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado guardar(Empleado entidad) throws Exception {
        try{
            entidad = emp.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado actualizar(Empleado entidad, Long id) throws Exception {
        try{
            Optional<Empleado> capturo = emp.findById(id);
            Empleado temp = capturo.get();
            temp = emp.save(entidad);
            return temp;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean borrar(Long id) throws Exception {
        try{
            if(emp.existsById(id)){
                emp.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
