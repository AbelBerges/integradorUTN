package com.cursoutn.integrador.controladores;
import com.cursoutn.integrador.entidades.Empleado;
import com.cursoutn.integrador.servicios.ServicioEmpleado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/empleados")
public class EmpleadoControlador {
    private ServicioEmpleado elServ;

    public EmpleadoControlador(ServicioEmpleado elServ){
        this.elServ = elServ;
    }

    @GetMapping("")
    public ResponseEntity<?> capturoTodo(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(elServ.seleccionarTodo());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se han encontrado registros\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> capturoUno(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(elServ.seleccionarUno(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se ha encontrado el registro\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardoEmpleado(Empleado empleado){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(elServ.guardar(empleado));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido guardar el registro\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizoEmpleado(@RequestBody Empleado empleado,@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(elServ.actualizar(empleado, id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido actualizar el registro\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(elServ.borrar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido borrar el registro");
        }
    }
}

