package com.portafolioAgus.portafolio.service.impl;

import com.portafolioAgus.portafolio.dto.CertificacionesDTO;
import com.portafolioAgus.portafolio.models.Certificaciones;


import java.util.List;

public interface ImplCertificacionesService {

    List<Certificaciones> findAllCertificaciones();

    List<CertificacionesDTO> listCertificacionToListCertificacionesDTO(List<Certificaciones> listadoCertificaciones);

    CertificacionesDTO certificacionesToCertificacionesDTO(Certificaciones certificaciones);

    Certificaciones findByIdCertificaciones(Long id);

    void saveCertificaciones(Certificaciones certificaciones);

    void deleteCertificacionesById(Long id);
}
