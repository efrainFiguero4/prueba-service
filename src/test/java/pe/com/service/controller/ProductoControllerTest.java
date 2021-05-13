package pe.com.service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import pe.com.service.model.Cliente;
import pe.com.service.model.Producto;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class ProductoControllerTest {

    @Autowired
    private ProductoController productoController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(productoController).isNotNull();
    }

    @Test
    public void listarProductosTest() throws Exception {
        ResponseEntity<List<Producto>> response = productoController.listarProductos();
        assertEquals(response.getStatusCode(), HttpStatus.OK, "codigo OK");
        assertEquals(Objects.requireNonNull(response.getBody()).size(), 3, "Productos igual a 3");
    }

    @Test
    public void obtenerProductoTest() throws Exception {
        ResponseEntity<Producto> response = productoController.obtenerProducto("PROD00111");
        assertEquals(response.getStatusCode(), HttpStatus.OK, "codigo OK");
        assertEquals(Objects.requireNonNull(response.getBody()).getCodigo(), "PROD00111", "Codigo son iguales");
    }

    @Test
    public void obtenerProductoXClienteTest() {
        ResponseEntity<List<Producto>> response = productoController.obtenerProductoXCliente("efigueroa");
        assertEquals(response.getStatusCode(), HttpStatus.OK, "codigo OK");
        assertEquals(Objects.requireNonNull(response.getBody()).size(), 2, "Usuario efigueroa Tiene 2 productos");
    }
}
