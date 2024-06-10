package com.tutorial.descuentobonosservice.controller;


import com.tutorial.descuentobonosservice.entity.DescuentoBonos;
import com.tutorial.descuentobonosservice.service.DescuentoBonosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// @RequestMapping("/api/descuentos-bonos")
@RequestMapping("/descuento-bonos")
public class DescuentoBonosController {

    @Autowired
    private DescuentoBonosService descuentoBonosService;

    // -----------------------------------------------CRUD------------------------------------------------------------//
    // Crear un nuevo descuento de bono
    @PostMapping("/")
    public ResponseEntity<DescuentoBonos> createDescuentoBono(@RequestBody DescuentoBonos descuentoBono) {
        DescuentoBonos newDescuentoBono = descuentoBonosService.saveDescuentoBono(descuentoBono);
        return new ResponseEntity<>(newDescuentoBono, HttpStatus.CREATED);
    }
    // Obtener un descuento de bono por ID
    @GetMapping("/{id}")
    public ResponseEntity<DescuentoBonos> getDescuentoBonoById(@PathVariable Integer id) {
        return descuentoBonosService.findById(id)
                .map(descuentoBono -> new ResponseEntity<>(descuentoBono, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // Actualizar un descuento de bono
    @PutMapping("/{id}")
    public ResponseEntity<DescuentoBonos> updateDescuentoBono(@PathVariable Integer id,
                                                              @RequestBody DescuentoBonos descuentoBono) {
        return descuentoBonosService.findById(id)
                .map(existingDescuentoBono -> {
                    descuentoBono.setId(existingDescuentoBono.getId()); // Asegura que se conserve el ID
                    DescuentoBonos updatedDescuentoBono = descuentoBonosService.updateDescuentoBono(descuentoBono);
                    return new ResponseEntity<>(updatedDescuentoBono, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // Eliminar un descuento de bono por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDescuentoBono(@PathVariable Integer id) {
        return descuentoBonosService.findById(id)
                .map(descuentoBono -> {
                    descuentoBonosService.deleteDescuentoBono(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // Listar todos los descuentos de bonos
    @GetMapping
    public ResponseEntity<Iterable<DescuentoBonos>> getAllDescuentosBonos() {
        Iterable<DescuentoBonos> descuentosBonos = descuentoBonosService.findAllDescuentosBonos();
        return new ResponseEntity<>(descuentosBonos, HttpStatus.OK);
    }
    // -----------------------------------------------CRUD------------------------------------------------------------//
}

