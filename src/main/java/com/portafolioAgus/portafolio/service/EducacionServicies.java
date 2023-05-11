package com.portafolioAgus.portafolio.service;


import com.portafolioAgus.portafolio.dto.EducacionDTO;
import com.portafolioAgus.portafolio.entity.Educacion;
import com.portafolioAgus.portafolio.repositories.EducacionRepository;
import com.portafolioAgus.portafolio.service.impl.ImplEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EducacionServicies implements ImplEducacionService {

    @Autowired
    EducacionRepository certificacionesRepository;

    @Override
    public List<Educacion> findAllCertificaciones() {
        return certificacionesRepository.findAll();
    }

    @Override
    public List<EducacionDTO> listCertificacionToListCertificacionesDTO(List<Educacion> listadoCertificaciones){
        return certificacionesRepository.findAll().stream().map(certificaciones -> new EducacionDTO(certificaciones)).collect(Collectors.toList());
    }

    @Override
    public EducacionDTO certificacionesToCertificacionesDTO(Educacion educacion) {
        return new EducacionDTO(educacion);
    }

    @Override
    public Educacion findByIdCertificaciones(Long id) {
        return certificacionesRepository.findById(id).orElse(null);
    }


    @Override
    public void saveCertificaciones(Educacion educacion) {
        certificacionesRepository.save(educacion);
    }

    @Override
    public void deleteCertificacionesById(Long id) {
        certificacionesRepository.deleteById(id);
    }
}
