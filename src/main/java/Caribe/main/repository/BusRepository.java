package Caribe.main.repository;

import Caribe.main.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusRepository extends JpaRepository<Bus, UUID> {
}
