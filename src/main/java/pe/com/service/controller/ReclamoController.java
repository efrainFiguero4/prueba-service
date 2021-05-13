package pe.com.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.com.service.model.Reclamo;
import pe.com.service.service.ReclamoService;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/reclamo")
public class ReclamoController {

    private final ReclamoService reclamoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Reclamo>> listarReclamos() {
        return ResponseEntity.ok(reclamoService.listarReclamos());
    }

    @PostMapping("/registrar")
    public ResponseEntity<Reclamo> registrarReclamo(@Valid @RequestBody Reclamo reclamo) {
        return ResponseEntity.ok(reclamoService.registrarReclamo(reclamo));
    }

    @GetMapping("/producto/{codigoProducto}")
    public ResponseEntity<List<Reclamo>> obtenerReclamoXProducto(@PathVariable String codigoProducto) {
        return ResponseEntity.ok(reclamoService.listarReclamosPorProducto(codigoProducto));
    }

    @GetMapping("/cliente/{codigoCliente}")
    public ResponseEntity<List<Reclamo>> obtenerProductoXCliente(@PathVariable String codigoCliente) {
        return ResponseEntity.ok(reclamoService.listarReclamosPorCliente(codigoCliente));
    }
}
