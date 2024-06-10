package com.tutorial.registrodereparacionesservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Date;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name = "registro_de_reparaciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class RegistroDeReparaciones {
    // Atributos:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_de_reparaciones")
    Integer id;

    @Column(name = "id_vehiculo")
    Integer idVehiculo;

    @Column(name = "id_reparacion")
    Integer idReparacion;

    @Column(name = "fecha_ingreso_taller")
    LocalDate fechaIngresoTaller;
    @Column(name = "hora_ingreso_taller")
    LocalTime HoraIngresoTaller;

    @Column(name = "fecha_salida_reparacion")
    LocalDate fechaSalidaReparacion;
    @Column(name = "hora_salida_reparacion")
    LocalTime HoraSalidaReparacion;

    @Column(name = "fecha_cliente_llevo_vehiculo")
    LocalDate fechaClienteLlevoVehiculo;
    @Column(name = "hora_cliente_llevo_vehiculo")
    LocalTime HoraClienteLlevoVehiculo;
}