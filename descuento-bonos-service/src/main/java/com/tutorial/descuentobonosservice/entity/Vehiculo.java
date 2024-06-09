package com.tutorial.descuentobonosservice.entity;

// import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "vehiculo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Vehiculo {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    Integer id;

    @Column(name = "numero_patente")
    String numeroPatente;

    @Column(name = "marca")
    String marca;

    @Column(name = "modelo")
    String modelo;

    @Column(name = "tipo")
    String tipo; // Sedán, Hatchback, SUV, Pickup, Furgoneta

    @Column(name = "ano_fabricacion")
    Integer anoFabricacion;

    @Column(name = "tipo_motor")
    String tipoMotor; // Gasolina, Diésel, Híbrido, Eléctrico

    @Column(name = "numero_asientos")
    int numeroAsientos;

    @Column(name = "kilometraje")
    int kilometraje;
}
