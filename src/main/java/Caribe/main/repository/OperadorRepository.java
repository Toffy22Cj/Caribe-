package Caribe.main.repository;

import Caribe.main.model.Operador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperadorRepository extends JpaRepository<Operador, UUID> {
}
