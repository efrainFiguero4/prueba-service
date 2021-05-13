package pe.com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.service.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public Producto findByCodigo(String codigoProducto);

    public List<Producto> findByCodigoCliente(String codigoCliente);

}
