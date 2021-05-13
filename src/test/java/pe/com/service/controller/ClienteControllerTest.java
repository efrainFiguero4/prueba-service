package pe.com.service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import pe.com.service.model.Cliente;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class ClienteControllerTest {

    @Autowired
    private ClienteController clienteController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(clienteController).isNotNull();
    }

    @Test
    public void listarClientesTest() throws Exception {
        ResponseEntity<List<Cliente>> response = clienteController.listarClientes();
        assertEquals(response.getStatusCode(), HttpStatus.OK, "codigo OK");
        assertTrue(Objects.requireNonNull(response.getBody()).size() > 0, "Clientes mayor a 0");
    }

    @Test
    public void obtenerClienteTest() throws Exception {
        ResponseEntity<Cliente> response = clienteController.obtenerCliente("efigueroa");
        assertEquals(response.getStatusCode(), HttpStatus.OK, "codigo OK");
        assertEquals(Objects.requireNonNull(response.getBody()).getNombres(), "Efrain", "Nombre es igual a Efrain");
    }

}
