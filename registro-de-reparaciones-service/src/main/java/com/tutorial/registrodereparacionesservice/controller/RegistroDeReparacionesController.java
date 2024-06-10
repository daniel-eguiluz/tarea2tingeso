package com.tutorial.registrodereparacionesservice.controller;


import com.tutorial.registrodereparacionesservice.entity.RegistroDeReparaciones;
import com.tutorial.registrodereparacionesservice.service.RegistroDeReparacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
//@RequestMapping("/api/registros-reparaciones")
@RequestMapping("/registro-reparaciones")
public class RegistroDeReparacionesController {

    @Autowired
    private RegistroDeReparacionesService registroDeReparacionesService;

    // Crear un nuevo registro de reparación
    @PostMapping("/")
    public ResponseEntity<RegistroDeReparaciones> createRegistroDeReparaciones(@RequestBody RegistroDeReparaciones registroDeReparaciones) {
        RegistroDeReparaciones newRegistro = registroDeReparacionesService.saveRegistroDeReparacion(registroDeReparaciones);
        return new ResponseEntity<>(newRegistro, HttpStatus.CREATED);
    }

    // Obtener un registro de reparación por ID
    @GetMapping("/{id}")
    public ResponseEntity<RegistroDeReparaciones> getRegistroDeReparacionesById(@PathVariable Integer id) {
        Optional<RegistroDeReparaciones> registro = registroDeReparacionesService.findById(id);
        return registro.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar un registro de reparación
    @PutMapping("/{id}")
    public ResponseEntity<RegistroDeReparaciones> updateRegistroDeReparaciones(@PathVariable Integer id, @RequestBody RegistroDeReparaciones registroDeReparaciones) {
        return registroDeReparacionesService.findById(id)
                .map(existingRegistro -> {
                    registroDeReparaciones.setId(existingRegistro.getId());
                    RegistroDeReparaciones updatedRegistro = registroDeReparacionesService.updateRegistroDeReparacion(registroDeReparaciones);
                    return new ResponseEntity<>(updatedRegistro, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar un registro de reparación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistroDeReparaciones(@PathVariable Integer id) {
        if (registroDeReparacionesService.findById(id).isPresent()) {
            registroDeReparacionesService.deleteRegistroDeReparacion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Listar todos los registros de reparaciones
    @GetMapping("/")
    public ResponseEntity<Iterable<RegistroDeReparaciones>> getAllRegistrosDeReparaciones() {
        Iterable<RegistroDeReparaciones> registros = registroDeReparacionesService.findAllRegistrosDeReparaciones();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }
}

