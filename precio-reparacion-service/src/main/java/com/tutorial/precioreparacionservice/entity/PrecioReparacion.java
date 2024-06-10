package com.tutorial.precioreparacionservice.entity;

// import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "precio_reparacion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PrecioReparacion {
    // Atributos:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_precio_reparacion")
    Integer id;

    @Column(name = "tipo_reparacion")
    String tipoReparacion;

    @Column(name = "costo_gasolina")
    int costoGasolina;

    @Column(name = "costo_diesel")
    int costoDiesel;

    @Column(name = "costo_hibrido")
    int costoHibrido;

    @Column(name = "costo_electrico")
    int costoElectrico;
}
