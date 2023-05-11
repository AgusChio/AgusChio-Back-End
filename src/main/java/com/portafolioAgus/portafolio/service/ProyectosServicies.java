package com.portafolioAgus.portafolio.service;


import com.portafolioAgus.portafolio.dto.ProyectosDTO;
import com.portafolioAgus.portafolio.entity.Proyectos;
import com.portafolioAgus.portafolio.repositories.ProyectosRepository;
import com.portafolioAgus.portafolio.service.impl.ImplProyectosService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProyectosServicies implements ImplProyectosService {

    @Autowired
    ProyectosRepository proyectosRepository;


    @Override
    public List<Proyectos> findAllProyectos() {
        return proyectosRepository.findAll();
    }

    @Override
    public List<ProyectosDTO> listProyectosToListProyectosDTO(List<Proyectos> proyectos) {
        return proyectosRepository.findAll().stream().map(proyectos1 -> new ProyectosDTO(proyectos1)).collect(Collectors.toList());
    }

    @Override
    public ProyectosDTO proyectosToProyectosDTO(Proyectos proyectos) {
        return new ProyectosDTO(proyectos);
    }

    @Override
    public Proyectos findByIdProyectos(Long id) {
        return proyectosRepository.findById(id).orElse(null);
    }

    @Override
    public Proyectos updateProyectos(ProyectosDTO newProyectos) {
        var proyectos = Proyectos.builder().build();
        BeanUtils.copyProperties(newProyectos, proyectos);
        return proyectos;
    }

    @Override
    public void saveProyectos(Proyectos proyectos) {
        proyectosRepository.save(proyectos);
    }

    @Override
    public void deleteProyectosById(Long id) {
        proyectosRepository.deleteById(id);
    }
}
