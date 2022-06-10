package com.dmedinao.dispapeles.cliente.controladores;

import com.dmedinao.dispapeles.cliente.modelos.dto.ClienteDTO;
import com.dmedinao.dispapeles.cliente.servicios.ClienteServicioInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
@AllArgsConstructor
public class ClienteControlador {

    private final ClienteServicioInterface clienteServicio;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodo(){
        return ResponseEntity.ok(clienteServicio.obtenerTodo());
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDTO> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteServicio.obtenerPorId(id));
    }

    @PostMapping()
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO cliente){
        return ResponseEntity.ok(clienteServicio.crearCliente(cliente));
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteDTO> actualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente){
        return ResponseEntity.ok(clienteServicio.actualizarCliente(id, cliente));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> eliminarClientePorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteServicio.eliminarClientePorId(id));
    }
}
