package pe.com.service.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import pe.com.service.model.Cliente;
import pe.com.service.model.Reclamo;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class ReclamoControllerTest {

    @Autowired
    private ReclamoController reclamoController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(reclamoController).isNotNull();
    }

    final String codigoCliente = "codigoCliente";
    final String codigoProducto = "PROD00333";

    @BeforeEach
    public void setUp(){
        Reclamo reclamo = new Reclamo();
        reclamo.setCodigoCliente(codigoCliente);
        reclamo.setDescripcion("reclamo de prueba");
        reclamo.setMotivo("Falla de equipo");
        reclamo.setCodigoProducto(codigoProducto);

        reclamoController.registrarReclamo(reclamo);
    }

    @Test
    public void registrarReclamoTest() throws Exception {

        Reclamo reclamo = new Reclamo();
        reclamo.setCodigoCliente("gonzales");
        reclamo.setDescripcion("reclamo de prueba");
        reclamo.setMotivo("Falla de equipo");
        reclamo.setCodigoProducto("PROD00444");

        ResponseEntity<Reclamo> response = reclamoController.registrarReclamo(reclamo);
        assertEquals(response.getStatusCode(), HttpStatus.OK, "statusCode OK");
        assertEquals(Objects.requireNonNull(response.getBody()).getCodigoCliente(), "gonzales", "Cliente registrado");
    }

    @Test
    public void obtenerReclamoXProductoTest() throws Exception {
        ResponseEntity<List<Reclamo>> response = reclamoController.obtenerReclamoXProducto(codigoProducto);
        assertEquals(response.getStatusCode(), HttpStatus.OK, "statusCode OK");
        assertEquals(Objects.requireNonNull(response.getBody()).size(), 2, "Tiene 1 registrado con codigoProducto: " + codigoProducto);
    }

    @Test
    public void obtenerProductoXClienteTest() throws Exception {
        ResponseEntity<List<Reclamo>> response = reclamoController.obtenerProductoXCliente(codigoCliente);
        assertEquals(response.getStatusCode(), HttpStatus.OK, "statusCode OK");
        assertEquals(Objects.requireNonNull(response.getBody()).size(), 1, "Tiene 1 registrado con codigoCliente: " + codigoCliente);
    }

}
