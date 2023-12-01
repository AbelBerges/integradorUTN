package com.cursoutn.integrador.controladores;
import com.cursoutn.integrador.entidades.Cliente;
import com.cursoutn.integrador.servicios.ServicioCliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/cliente")
public class ClienteControlador {
    private ServicioCliente serv;

    public ClienteControlador(ServicioCliente serv){
        this.serv = serv;
    }

    @GetMapping("")
    public ResponseEntity<?> tomarTodo(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(serv.seleccionarTodo());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se han encontrado registros\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUno(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(serv.seleccionarUno(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se ha encontrado el registro\"}");
        }

    }

    @PostMapping("")
    public ResponseEntity<?> guardoCliente(@RequestBody Cliente cliente){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(serv.guardar(cliente));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\"·\"No se ha podido guardar el cliente\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actuallizoCliente(@RequestBody Cliente cli,@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(serv.actualizar(cli,id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se ha podido actualizar el Cliente\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borroCliente(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(serv.borrar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No existe el registro para borrar\"}");
        }
    }
}
