package com.tutorial.descuentobonosservice.service;

import com.tutorial.descuentobonosservice.entity.DescuentoBonos;
import com.tutorial.descuentobonosservice.repository.DescuentoBonosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DescuentoBonosService {

    @Autowired
    private DescuentoBonosRepository descuentoBonosRepository;

    //-------------------CRUD-------------------//
    // Agregar un nuevo descuento de bono
    public DescuentoBonos saveDescuentoBono(DescuentoBonos descuentoBono) {return descuentoBonosRepository.save(descuentoBono);}
    // Buscar un descuento de bono por ID
    public Optional<DescuentoBonos> findById(Integer id) {return descuentoBonosRepository.findById(id);}
    // Actualizar un descuento de bono
    public DescuentoBonos updateDescuentoBono(DescuentoBonos descuentoBono) {return descuentoBonosRepository.save(descuentoBono);}
    // Eliminar un descuento de bono por ID
    public void deleteDescuentoBono(Integer id) {descuentoBonosRepository.deleteById(id);}
    // Listar todos los descuentos de bonos
    public Iterable<DescuentoBonos> findAllDescuentosBonos() {return descuentoBonosRepository.findAll();}
    //-------------------FIN CRUD-------------------//


}
