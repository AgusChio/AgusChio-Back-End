package com.portafolioAgus.portafolio.service;


import com.portafolioAgus.portafolio.dto.CertificacionesDTO;
import com.portafolioAgus.portafolio.models.Certificaciones;
import com.portafolioAgus.portafolio.repositories.CertificacionesRepository;
import com.portafolioAgus.portafolio.service.impl.ImplCertificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CertificacionesServicies implements ImplCertificacionesService {

    @Autowired
    CertificacionesRepository certificacionesRepository;

    @Override
    public List<Certificaciones> findAllCertificaciones() {
        return certificacionesRepository.findAll();
    }

    @Override
    public List<CertificacionesDTO> listCertificacionToListCertificacionesDTO(List<Certificaciones> listadoCertificaciones){
        return certificacionesRepository.findAll().stream().map(certificaciones -> new CertificacionesDTO(certificaciones)).collect(Collectors.toList());
    }

    @Override
    public CertificacionesDTO certificacionesToCertificacionesDTO(Certificaciones certificaciones) {
        return new CertificacionesDTO(certificaciones);
    }

    @Override
    public Certificaciones findByIdCertificaciones(Long id) {
        return certificacionesRepository.findById(id).orElse(null);
    }


    @Override
    public void saveCertificaciones(Certificaciones certificaciones) {
        certificacionesRepository.save(certificaciones);
    }

    @Override
    public void deleteCertificacionesById(Long id) {
        certificacionesRepository.deleteById(id);
    }
}
