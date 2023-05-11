package com.portafolioAgus.portafolio.service.impl;

import com.portafolioAgus.portafolio.dto.ProyectosDTO;
import com.portafolioAgus.portafolio.entity.Proyectos;

import java.util.List;

public interface ImplProyectosService {

    List<Proyectos> findAllProyectos();

    List<ProyectosDTO> listProyectosToListProyectosDTO(List<Proyectos> proyectos);

    ProyectosDTO proyectosToProyectosDTO(Proyectos proyectos);

    Proyectos findByIdProyectos(Long id);

    Proyectos updateProyectos(ProyectosDTO newProyectos);

    void saveProyectos(Proyectos proyectos);

    void deleteProyectosById(Long id);
}
