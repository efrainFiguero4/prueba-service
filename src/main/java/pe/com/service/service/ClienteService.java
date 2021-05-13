package pe.com.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.service.model.Cliente;
import pe.com.service.repository.ClienteRepository;

import java.util.List;

public interface ClienteService {

    public List<Cliente> obtenerClientes() ;

    public Cliente obtenerCliente(String codigoCliente);
}
