package com.portafolioAgus.portafolio.service.impl;

import com.portafolioAgus.portafolio.dto.EducacionDTO;
import com.portafolioAgus.portafolio.entity.Educacion;


import java.util.List;

public interface ImplEducacionService {

    List<Educacion> findAllEducacion();

    List<EducacionDTO> listEducacionToListEducacionDTO(List<Educacion> listadoEducacion);

    EducacionDTO EducacionToEducacionDTO(Educacion educacion);

    Educacion findByIdEducacion(Long id);

    void saveEducacion(Educacion educacion);

    void deleteEducacionById(Long id);
}
