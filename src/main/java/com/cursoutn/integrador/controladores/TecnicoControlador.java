package com.cursoutn.integrador.controladores;
import com.cursoutn.integrador.entidades.Tecnico;
import com.cursoutn.integrador.servicios.ServicioTecnico;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/tecnicos")
public class TecnicoControlador {
    private ServicioTecnico elSerTec;

    public TecnicoControlador(ServicioTecnico elSerTec){
        this.elSerTec = elSerTec;
    }

    @GetMapping("")
    public ResponseEntity<?> buscoTodo(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(elSerTec.seleccionarTodo());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se han encontrado registros\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscoUno(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(elSerTec.seleccionarUno(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se ha encontrado el registro\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardo(@RequestBody Tecnico tec){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(elSerTec.guardar(tec));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido guardar el registro\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizo(@RequestBody Tecnico tec,@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(elSerTec.actualizar(tec,id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha encontrado el registro\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borro(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(elSerTec.borrar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha encontrado el registro\"}");
        }
    }
}
