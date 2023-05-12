package com.portafolioAgus.portafolio.dto;

import com.portafolioAgus.portafolio.entity.Proyectos;
import lombok.*;

import java.time.LocalDate;


@Getter
public class ProyectosDTO {
    private Long id;

    private String nombreProyecto;

    private String imagen;

    private String descripcion;

    private LocalDate fechaRealizacion;

    private String urlVideo;

    private String urlGitHub;

    private String urlDeploy;


    public ProyectosDTO(Proyectos proyectos) {
        id = proyectos.getId();
        nombreProyecto = proyectos.getNombreProyecto();
        imagen = proyectos.getImagen();
        descripcion = proyectos.getDescripcion();
        fechaRealizacion = proyectos.getFechaRealizacion();
        urlVideo = proyectos.getUrlVideo();
        urlDeploy = proyectos.getUrlDeploy();
        urlGitHub = proyectos.getUrlGitHub();
    }
}
