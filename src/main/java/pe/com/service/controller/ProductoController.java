package pe.com.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.service.model.Producto;
import pe.com.service.service.ProductoService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @GetMapping("/{codigoProducto}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable String codigoProducto) {
        return ResponseEntity.ok(productoService.obtenerProducto(codigoProducto));
    }

    @GetMapping("/cliente/{codigoCliente}")
    public ResponseEntity<List<Producto>> obtenerProductoXCliente(@PathVariable String codigoCliente) {
        return ResponseEntity.ok(productoService.listarProductoXCliente(codigoCliente));
    }
}
