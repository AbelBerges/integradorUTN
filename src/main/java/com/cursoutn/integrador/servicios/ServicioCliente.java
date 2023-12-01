package com.cursoutn.integrador.servicios;

import com.cursoutn.integrador.entidades.Cliente;
import com.cursoutn.integrador.repositorios.ClienteRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCliente implements ServicioBase<Cliente> {

    private ClienteRepositorio elRepo;
    public ServicioCliente(ClienteRepositorio elRepo){
        this.elRepo = elRepo;
    }

    @Override
    @Transactional
    public List<Cliente> seleccionarTodo() throws Exception {
        try{
            List<Cliente> lista = elRepo.findAll();
            return lista;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente seleccionarUno(Long id) throws Exception {
        try{
            Optional<Cliente> elCliente = elRepo.findById(id);
            return elCliente.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente guardar(Cliente entidad) throws Exception {
        try{
            entidad = elRepo.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente actualizar(Cliente entidad, Long id) throws Exception {
        try{
            Optional<Cliente> elCliente = elRepo.findById(id);
            Cliente temp = elCliente.get();
            temp = elRepo.save(entidad);
            return temp;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean borrar(Long id) throws Exception {
        try{
            if(elRepo.existsById(id)){
                elRepo.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
