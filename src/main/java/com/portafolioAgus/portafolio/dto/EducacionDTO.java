package com.portafolioAgus.portafolio.dto;

import com.portafolioAgus.portafolio.entity.Educacion;
import lombok.*;

import java.time.LocalDate;

@Getter
public class EducacionDTO {
    private Long id;

    private String titulo;

    private String entidadEducativa;

    private String inicio;

    private String fin;

    private String imagenCertificado;


    public EducacionDTO(Educacion educacion) {
        id = educacion.getId();
        titulo = educacion.getTitulo();
        entidadEducativa = educacion.getEntidadEducativa();
        inicio = educacion.getInicio();
        fin = educacion.getFin();
        imagenCertificado = educacion.getImagenCertificado();
    }
}
