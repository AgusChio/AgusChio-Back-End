package com.portafolioAgus.portafolio.dto;

import com.portafolioAgus.portafolio.models.Certificaciones;
import com.portafolioAgus.portafolio.models.Persona;
import lombok.*;

import java.time.LocalDate;

@Getter
public class CertificacionesDTO {
    private Long id;

    private String titulo;

    private String entidadEducativa;

    private LocalDate inicio;

    private LocalDate fin;

    private String imagenCertificado;


    public CertificacionesDTO(Certificaciones certificaciones) {
        id = certificaciones.getId();
        titulo = certificaciones.getTitulo();
        entidadEducativa = certificaciones.getEntidadEducativa();
        inicio = certificaciones.getInicio();
        fin = certificaciones.getFin();
        imagenCertificado = certificaciones.getImagenCertificado();
    }
}
