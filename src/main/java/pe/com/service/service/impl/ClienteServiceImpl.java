package pe.com.service.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pe.com.service.model.Cliente;
import pe.com.service.model.Producto;
import pe.com.service.repository.ClienteRepository;
import pe.com.service.repository.ProductoRepository;
import pe.com.service.service.ClienteService;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;


    public List<Cliente> obtenerClientes() {
        List<Cliente> lista = clienteRepository.findAll();
        lista.forEach(c -> c.getProductos().addAll(getProductos(c.getCodigo())));
        return lista;
    }

    public Cliente obtenerCliente(String codigoCliente) {
        Cliente cliente = clienteRepository.findByCodigo(codigoCliente);
        cliente.getProductos().addAll(getProductos(codigoCliente));
        return cliente;
    }

    public List<Producto> getProductos(String codigoCliente) {
        return productoRepository.findByCodigoCliente(codigoCliente);
    }
}
