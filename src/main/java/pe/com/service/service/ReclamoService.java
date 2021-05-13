package pe.com.service.service;

import org.springframework.stereotype.Service;
import pe.com.service.model.Reclamo;

import java.util.List;

@Service
public interface ReclamoService {

    public Reclamo registrarReclamo(Reclamo reclamo);

    public List<Reclamo> listarReclamos();

    public List<Reclamo> listarReclamosPorCliente(String codigoCliente);

    public List<Reclamo> listarReclamosPorProducto(String codigoProducto);

}
