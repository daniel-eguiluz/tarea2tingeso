package com.tutorial.vehiculoservice.controller;

/*
import com.autofix.gestionReparaciones.entities.RegistroDeReparaciones;
import com.autofix.gestionReparaciones.entities.Vehiculo;
import com.autofix.gestionReparaciones.services.VehiculoService;
import com.autofix.gestionReparaciones.services.RegistroDeReparacionesService;

import jakarta.persistence.EntityNotFoundException;
 */

import com.tutorial.vehiculoservice.entity.Vehiculo;
import com.tutorial.vehiculoservice.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.HashMap;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    // ---------CRUD----------
    // Crear un nuevo vehículo
    @PostMapping
    public ResponseEntity<Vehiculo> createVehiculo(@RequestBody Vehiculo vehiculo) {
        Vehiculo nuevoVehiculo = vehiculoService.saveVehiculo(vehiculo);
        return new ResponseEntity<>(nuevoVehiculo, HttpStatus.CREATED);
    }

    // Obtener un vehículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable Integer id) {
        Optional<Vehiculo> vehiculo = vehiculoService.findVehiculoById(id);
        return vehiculo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar un vehículo
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable Integer id, @RequestBody Vehiculo vehiculo) {
        return vehiculoService.findVehiculoById(id)
                .map(existingVehiculo -> {
                    vehiculo.setId(existingVehiculo.getId()); // Asegura que se conserve el ID
                    Vehiculo updatedVehiculo = vehiculoService.updateVehiculo(vehiculo);
                    return new ResponseEntity<>(updatedVehiculo, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar un vehículo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable Integer id) {
        if (vehiculoService.findVehiculoById(id).isPresent()) {
            vehiculoService.deleteVehiculo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Listar todos los vehículos
    @GetMapping
    public ResponseEntity<Iterable<Vehiculo>> getAllVehiculos() {
        Iterable<Vehiculo> vehiculos = vehiculoService.findAllVehiculos();
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }
}
