package pe.com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.service.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByCodigo(String codigoCliente);
}
