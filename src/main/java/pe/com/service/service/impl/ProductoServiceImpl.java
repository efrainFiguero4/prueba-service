package pe.com.service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.service.model.Producto;
import pe.com.service.repository.ProductoRepository;
import pe.com.service.service.ProductoService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProducto(String codigoProducto) {
        return productoRepository.findByCodigo(codigoProducto);
    }

    @Override
    public List<Producto> listarProductoXCliente(String codigoCliente) {
        return productoRepository.findByCodigoCliente(codigoCliente);
    }
}
