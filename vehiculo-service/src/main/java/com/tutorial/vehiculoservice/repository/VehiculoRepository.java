package com.tutorial.vehiculoservice.repository;

import com.tutorial.vehiculoservice.entity.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer> {
    //-------PARA LA FUNCIONALIDAD 6 --------------------
    // Este método encuentra todos los vehículos por la marca proporcionada
    List<Vehiculo> findByMarca(String marca);

    // Consulta JPQL para obtener todas las marcas distintas de vehículos
    @Query("SELECT DISTINCT v.marca FROM Vehiculo v")
    List<String> findDistinctMarcas();
}
