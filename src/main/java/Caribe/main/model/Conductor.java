package Caribe.main.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "conductores")
@SQLDelete(sql = "UPDATE conductores SET activo = false WHERE id_conductor = ?")
@SQLRestriction("activo = true")
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_conductor")
    private UUID id;

    @Column(nullable = false)
    private Boolean activo = true;

    @Column(name = "hora_inicio_jornada")
    private LocalDateTime horaInicioJornada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operador", nullable = false)
    private Operador operador;

    @OneToMany(mappedBy = "conductor")
    private List<PlantillaRegistroFlota> registrosFlota;
}
