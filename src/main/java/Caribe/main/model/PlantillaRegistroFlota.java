package Caribe.main.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "plantilla_registro_flota")
public class PlantillaRegistroFlota {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_registro")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ruta", nullable = false)
    private Ruta ruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus", nullable = false)
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conductor", nullable = false)
    private Conductor conductor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operador", nullable = false)
    private Operador operador;

    @Column(name = "fecha_despacho", nullable = false)
    private LocalDateTime fechaDespacho;

    @Column(name = "estado_viaje", nullable = false)
    private String estadoViaje;
}
