package pe.com.service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.service.model.Reclamo;
import pe.com.service.repository.ReclamoRepository;
import pe.com.service.service.ReclamoService;

import java.util.List;

@Service
@AllArgsConstructor
public class ReclamoServiceImpl implements ReclamoService {

    private final ReclamoRepository reclamoRepository;

    @Override
    public Reclamo registrarReclamo(Reclamo reclamo) {
        return reclamoRepository.saveAndFlush(reclamo);
    }

    @Override
    public List<Reclamo> listarReclamos() {
        return reclamoRepository.findAll();
    }

    @Override
    public List<Reclamo> listarReclamosPorCliente(String codigoCliente) {
        return reclamoRepository.findByCodigoCliente(codigoCliente);
    }

    @Override
    public List<Reclamo> listarReclamosPorProducto(String codigoProducto) {
        return reclamoRepository.findByCodigoProducto(codigoProducto);
    }
}
