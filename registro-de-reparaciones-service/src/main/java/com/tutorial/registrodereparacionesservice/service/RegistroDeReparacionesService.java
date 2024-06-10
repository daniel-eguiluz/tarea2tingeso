package com.tutorial.registrodereparacionesservice.service;

import com.tutorial.registrodereparacionesservice.entity.RegistroDeReparaciones;

import com.tutorial.registrodereparacionesservice.repository.RegistroDeReparacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;

@Service
public class RegistroDeReparacionesService {

    @Autowired
    private RegistroDeReparacionesRepository registroDeReparacionesRepository;

    // ---------------------------------------CRUD--------------------------------------------------------------------//
    // Agregar un nuevo registro de reparación
    public RegistroDeReparaciones saveRegistroDeReparacion(RegistroDeReparaciones registroDeReparaciones) {return registroDeReparacionesRepository.save(registroDeReparaciones);}
    // Buscar un registro de reparación por ID
    public Optional<RegistroDeReparaciones> findById(Integer id) {return registroDeReparacionesRepository.findById(id);}
    // Actualizar un registro de reparación
    public RegistroDeReparaciones updateRegistroDeReparacion(RegistroDeReparaciones registroDeReparaciones) {return registroDeReparacionesRepository.save(registroDeReparaciones);}
    // Eliminar un registro de reparación por ID
    public void deleteRegistroDeReparacion(Integer id) {registroDeReparacionesRepository.deleteById(id);}
    // Listar todos los registros de reparaciones
    public Iterable<RegistroDeReparaciones> findAllRegistrosDeReparaciones() {return registroDeReparacionesRepository.findAll();}
    // ---------------------------------------CRUD--------------------------------------------------------------------//
}

