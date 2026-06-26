package Caribe.main.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "operadores")
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_operador")
    private UUID id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata_contrato", columnDefinition = "jsonb")
    private Map<String, Object> metadataContrato;

    @OneToMany(mappedBy = "operador")
    private List<Conductor> conductores;

    @OneToMany(mappedBy = "operador")
    private List<Bus> buses;
}
