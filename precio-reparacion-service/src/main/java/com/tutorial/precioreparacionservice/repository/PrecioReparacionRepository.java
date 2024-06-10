package com.tutorial.precioreparacionservice.repository;

import com.tutorial.precioreparacionservice.entity.PrecioReparacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioReparacionRepository extends CrudRepository<PrecioReparacion, Integer> {
}
