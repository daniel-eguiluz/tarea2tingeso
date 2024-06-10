package com.tutorial.precioreparacionservice.service;

import com.tutorial.precioreparacionservice.entity.PrecioReparacion;
import com.tutorial.precioreparacionservice.repository.PrecioReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrecioReparacionService {

    @Autowired
    private PrecioReparacionRepository precioReparacionRepository;

    // ----------------------------------------------------CRUD-------------------------------------------------------//
    // Agregar un nuevo precio de reparación
    public PrecioReparacion savePrecioReparacion(PrecioReparacion precioReparacion) {return precioReparacionRepository.save(precioReparacion);}
    // Buscar un precio de reparación por ID
    public Optional<PrecioReparacion> findById(Integer id) {return precioReparacionRepository.findById(id);}
    // Actualizar un precio de reparación
    public PrecioReparacion updatePrecioReparacion(PrecioReparacion precioReparacion) {return precioReparacionRepository.save(precioReparacion);}
    // Eliminar un precio de reparación por ID
    public void deletePrecioReparacion(Integer id) {precioReparacionRepository.deleteById(id);}
    // Listar todos los precios de reparaciones
    public Iterable<PrecioReparacion> findAllPreciosReparaciones() {return precioReparacionRepository.findAll();}
    // ----------------------------------------------------FIN CRUD---------------------------------------------------//


}

