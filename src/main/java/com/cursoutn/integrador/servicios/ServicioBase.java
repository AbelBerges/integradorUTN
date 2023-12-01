package com.cursoutn.integrador.servicios;

import java.util.List;

public interface ServicioBase<E> {
    public List<E> seleccionarTodo() throws Exception;
    public E seleccionarUno(Long id) throws Exception;
    public E guardar(E entidad) throws Exception;
    public E actualizar(E entidad, Long id) throws Exception;
    public boolean borrar(Long id) throws Exception;
}
