package pe.com.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.service.model.Cliente;
import pe.com.service.service.ClienteService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.obtenerClientes());
    }

    @GetMapping("/{codigoCliente}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable String codigoCliente) {
        return ResponseEntity.ok(clienteService.obtenerCliente(codigoCliente));
    }
}
