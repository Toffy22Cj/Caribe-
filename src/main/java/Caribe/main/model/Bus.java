package Caribe.main.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_bus")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(name = "estado_operativo", nullable = false)
    private String estadoOperativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operador", nullable = false)
    private Operador operador;

    @OneToMany(mappedBy = "bus")
    private List<PlantillaRegistroFlota> registrosFlota;
}
