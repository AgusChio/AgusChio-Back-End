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
    EducacionRepository educacionRepository;

    @Override
    public List<Educacion> findAllEducacion() {
        return educacionRepository.findAll();
    }

    @Override
    public List<EducacionDTO> listEducacionToListEducacionDTO(List<Educacion> listadoEducacion){
        return educacionRepository.findAll().stream().map(educacion -> new EducacionDTO(educacion)).collect(Collectors.toList());
    }

    @Override
    public EducacionDTO EducacionToEducacionDTO(Educacion educacion) {
        return new EducacionDTO(educacion);
    }

    @Override
    public Educacion findByIdEducacion(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }


    @Override
    public void saveEducacion(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacionById(Long id) {
        educacionRepository.deleteById(id);
    }
}
