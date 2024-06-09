package com.tutorial.vehiculoservice.service;

import com.tutorial.vehiculoservice.entity.Vehiculo;
import com.tutorial.vehiculoservice.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    RestTemplate restTemplate;

    // Agregar un nuevo vehículo
    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    // Buscar un vehículo por ID
    public Optional<Vehiculo> findVehiculoById(Integer id) {
        return vehiculoRepository.findById(id);
    }

    // Actualizar un vehículo
    public Vehiculo updateVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    // Eliminar un vehículo por ID
    public void deleteVehiculo(Integer id) {
        vehiculoRepository.deleteById(id);
    }

    // Listar todos los vehículos
    public Iterable<Vehiculo> findAllVehiculos() {
        return vehiculoRepository.findAll();
    }
}
