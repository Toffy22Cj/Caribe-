package Caribe.main.repository;

import Caribe.main.model.PlantillaRegistroFlota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlantillaRegistroFlotaRepository extends JpaRepository<PlantillaRegistroFlota, UUID> {
}
