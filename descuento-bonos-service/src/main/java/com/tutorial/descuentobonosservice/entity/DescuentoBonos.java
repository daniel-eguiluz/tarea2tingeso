package com.tutorial.descuentobonosservice.entity;

// import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "descuento_bonos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class DescuentoBonos {
    // Atributos:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descuento_bono")
    Integer id;

    @Column(name = "descripcion")
    String descripcion;

    @Column(name = "porcentaje_de_descuento")
    Integer porcentajeDeDescuento;

    @Column(name = "marca")
    String marca;

    @Column(name = "monto_bono")
    Integer montoBono;

    @Column(name = "fecha_descuento")
    private LocalDate fechaDescuento;
}

