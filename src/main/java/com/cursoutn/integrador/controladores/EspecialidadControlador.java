package com.cursoutn.integrador.controladores;

import com.cursoutn.integrador.entidades.Especialidad;
import com.cursoutn.integrador.servicios.ServicioEspecialidad;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/especialidades")
public class EspecialidadControlador {
    private ServicioEspecialidad elServ;
    public EspecialidadControlador(ServicioEspecialidad elServ){
        this.elServ = elServ;
    }

    @GetMapping("")
    public ResponseEntity<?> buscoTodo(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(elServ.seleccionarTodo());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se han enontrado registros\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscouno(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(elServ.seleccionarUno(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se ha encontrado el registro\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardo(@RequestBody Especialidad laEsp){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(elServ.guardar(laEsp));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido guardar el registro\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizo(@RequestBody Especialidad especialidad,@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(elServ.actualizar(especialidad,id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido actualizar el registro\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(elServ.borrar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido borrar el registro\"}");
        }
    }
}
