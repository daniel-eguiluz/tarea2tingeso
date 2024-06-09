package com.tutorial.descuentobonosservice.repository;

import com.tutorial.descuentobonosservice.entity.DescuentoBonos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DescuentoBonosRepository extends CrudRepository<DescuentoBonos, Integer> {
    // ----PARA OBTENER LOS DECUENTO DE BONOS EN LA FUNCIONALIDAD 4---
    List<DescuentoBonos> findAllByMarca(String marca);
}
