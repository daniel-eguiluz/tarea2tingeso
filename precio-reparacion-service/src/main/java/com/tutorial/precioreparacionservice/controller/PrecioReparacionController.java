package com.tutorial.precioreparacionservice.controller;

import com.tutorial.precioreparacionservice.entity.PrecioReparacion;
import com.tutorial.precioreparacionservice.service.PrecioReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
// @RequestMapping("/api/precios-reparacion")
@RequestMapping("/precio-reparacion")
public class PrecioReparacionController {

    @Autowired
    private PrecioReparacionService precioReparacionService;

    // Crear un nuevo precio de reparación
    @PostMapping("/")
    public ResponseEntity<PrecioReparacion> createPrecioReparacion(@RequestBody PrecioReparacion precioReparacion) {
        PrecioReparacion newPrecioReparacion = precioReparacionService.savePrecioReparacion(precioReparacion);
        return new ResponseEntity<>(newPrecioReparacion, HttpStatus.CREATED);
    }

    // Obtener un precio de reparación por ID
    @GetMapping("/{id}")
    public ResponseEntity<PrecioReparacion> getPrecioReparacionById(@PathVariable Integer id) {
        Optional<PrecioReparacion> precioReparacion = precioReparacionService.findById(id);
        if (precioReparacion.isPresent()) {
            return new ResponseEntity<>(precioReparacion.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un precio de reparación
    @PutMapping("/{id}")
    public ResponseEntity<PrecioReparacion> updatePrecioReparacion(@PathVariable Integer id,
                                                                   @RequestBody PrecioReparacion precioReparacion) {
        return precioReparacionService.findById(id)
                .map(existingPrecioReparacion -> {
                    precioReparacion.setId(existingPrecioReparacion.getId());
                    PrecioReparacion updatedPrecioReparacion = precioReparacionService.updatePrecioReparacion(precioReparacion);
                    return new ResponseEntity<>(updatedPrecioReparacion, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar un precio de reparación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrecioReparacion(@PathVariable Integer id) {
        if (precioReparacionService.findById(id).isPresent()) {
            precioReparacionService.deletePrecioReparacion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Listar todos los precios de reparaciones
    @GetMapping("/")
    public ResponseEntity<Iterable<PrecioReparacion>> getAllPreciosReparaciones() {
        Iterable<PrecioReparacion> preciosReparacion = precioReparacionService.findAllPreciosReparaciones();
        return new ResponseEntity<>(preciosReparacion, HttpStatus.OK);
    }
}

