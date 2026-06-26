package Caribe.main.repository;

import Caribe.main.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConductorRepository extends JpaRepository<Conductor, UUID> {
}
