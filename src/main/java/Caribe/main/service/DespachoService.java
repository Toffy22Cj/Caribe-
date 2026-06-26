package Caribe.main.service;

import Caribe.main.model.*;
import Caribe.main.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DespachoService {

    private final BusRepository busRepository;
    private final ConductorRepository conductorRepository;
    private final RutaRepository rutaRepository;
    private final OperadorRepository operadorRepository;
    private final PlantillaRegistroFlotaRepository plantillaRegistroFlotaRepository;

    @Transactional
    public PlantillaRegistroFlota despacharBus(UUID idBus, UUID idConductor, UUID idRuta) {
        Bus bus = busRepository.findById(idBus)
                .orElseThrow(() -> new EntityNotFoundException("Bus no encontrado con id: " + idBus));

        Conductor conductor = conductorRepository.findById(idConductor)
                .orElseThrow(() -> new EntityNotFoundException("Conductor no encontrado con id: " + idConductor));

        Ruta ruta = rutaRepository.findById(idRuta)
                .orElseThrow(() -> new EntityNotFoundException("Ruta no encontrada con id: " + idRuta));

        bus.setEstadoOperativo("EN_RUTA");
        busRepository.save(bus);

        conductor.setHoraInicioJornada(LocalDateTime.now());
        conductorRepository.save(conductor);

        PlantillaRegistroFlota registro = new PlantillaRegistroFlota();
        registro.setBus(bus);
        registro.setConductor(conductor);
        registro.setRuta(ruta);
        registro.setOperador(bus.getOperador());
        registro.setFechaDespacho(LocalDateTime.now());
        registro.setEstadoViaje("EN_CURSO");

        return plantillaRegistroFlotaRepository.save(registro);
    }
}
