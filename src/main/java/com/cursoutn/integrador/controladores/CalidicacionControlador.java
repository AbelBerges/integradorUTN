package com.cursoutn.integrador.controladores;
import com.cursoutn.integrador.entidades.Calificacion;
import com.cursoutn.integrador.servicios.ServicioCalificacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/calificaciones")
public class CalidicacionControlador {
    private ServicioCalificacion laCali;
    public CalidicacionControlador(ServicioCalificacion laCali){
        this.laCali = laCali;
    }

    @GetMapping("")
    public ResponseEntity<?> buscarTodo(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(laCali.seleccionarTodo());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se han encontrado registros\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscoUno(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(laCali.seleccionarUno(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se han encontrado el registro\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardo(Calificacion cali){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(laCali.guardar(cali));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podidio guardar el registro\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Calificacion laEntidad,@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(laCali.actualizar(laEntidad,id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"NO se ha podido actualizar el registro");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borro(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(laCali.borrar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido borror el registro");
        }
    }
}
