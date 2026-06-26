package Caribe.main.repository;

import Caribe.main.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RutaRepository extends JpaRepository<Ruta, UUID> {
}
