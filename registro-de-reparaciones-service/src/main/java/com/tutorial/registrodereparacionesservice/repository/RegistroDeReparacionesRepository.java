package com.tutorial.registrodereparacionesservice.repository;

import com.tutorial.registrodereparacionesservice.entity.RegistroDeReparaciones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RegistroDeReparacionesRepository extends CrudRepository<RegistroDeReparaciones, Integer> {


}
