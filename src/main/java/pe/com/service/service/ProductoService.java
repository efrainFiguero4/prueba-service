package pe.com.service.service;

import org.springframework.stereotype.Service;
import pe.com.service.model.Producto;

import java.util.List;

@Service
public interface ProductoService {

    public List<Producto> listarProductos();

    public Producto obtenerProducto(String codigoProducto);

    public List<Producto> listarProductoXCliente(String codigoCliente);
}
