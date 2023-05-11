package com.portafolioAgus.portafolio.service.impl;

import com.portafolioAgus.portafolio.dto.EducacionDTO;
import com.portafolioAgus.portafolio.entity.Educacion;


import java.util.List;

public interface ImplEducacionService {

    List<Educacion> findAllCertificaciones();

    List<EducacionDTO> listCertificacionToListCertificacionesDTO(List<Educacion> listadoCertificaciones);

    EducacionDTO certificacionesToCertificacionesDTO(Educacion educacion);

    Educacion findByIdCertificaciones(Long id);

    void saveCertificaciones(Educacion educacion);

    void deleteCertificacionesById(Long id);
}
