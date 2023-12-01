package com.cursoutn.integrador.controladores;

import com.cursoutn.integrador.entidades.Estado;
import com.cursoutn.integrador.servicios.ServicioEstado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/estados")
public class EstadoControlador {
    private ServicioEstado elEstado;
    public EstadoControlador(ServicioEstado elEstado){
        this.elEstado = elEstado;
    }

    @GetMapping("")
    public ResponseEntity<?> buscoTodo(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(elEstado.seleccionarTodo());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se han encontrado registros\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscoUno(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(elEstado.seleccionarUno(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se ha encontrado el registro\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardo(@RequestBody Estado estado){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(elEstado.guardar(estado));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se podido guardar el registro\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizo(@RequestBody Estado est,@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(elEstado.actualizar(est,id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido actualizar el registro\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borro(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(elEstado.borrar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido borrar el registro\"}");
        }
    }
}
