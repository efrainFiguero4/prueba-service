package pe.com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.service.model.Reclamo;

import java.util.List;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {

    public List<Reclamo> findByCodigoCliente(String codigoCliente);

    public List<Reclamo> findByCodigoProducto(String codigoProducto);

}
