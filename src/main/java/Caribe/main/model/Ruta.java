package Caribe.main.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "rutas")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_ruta")
    private UUID id;

    @Column(name = "codigo_ruta", nullable = false, unique = true)
    private String codigoRuta;

    @Column(name = "nombre_ruta", nullable = false)
    private String nombreRuta;

    @OneToMany(mappedBy = "ruta")
    private List<PlantillaRegistroFlota> registrosFlota;
}
