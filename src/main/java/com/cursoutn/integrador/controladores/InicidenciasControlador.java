package com.cursoutn.integrador.controladores;
import com.cursoutn.integrador.entidades.Incidencias;
import com.cursoutn.integrador.servicios.ServicioIncidencias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/incidenicias")
public class InicidenciasControlador {
    private ServicioIncidencias lasInici;
    public InicidenciasControlador(ServicioIncidencias lasInici){
        this.lasInici = lasInici;
    }

    @GetMapping("")
    public ResponseEntity<?> buscoTodo(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(lasInici.seleccionarTodo());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se han encontrado registros\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscoUno(Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(lasInici.seleccionarUno(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se ha encontrado el registro\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardoRegistro(@RequestBody Incidencias inci){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(lasInici.guardar(inci));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido guardar el registro\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizo(@RequestBody Incidencias laInci,@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(lasInici.actualizar(laInci,id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podiodo actualizar el registro\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borroRegistro(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lasInici.borrar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido borrar el registro\"}");
        }
    }
}
