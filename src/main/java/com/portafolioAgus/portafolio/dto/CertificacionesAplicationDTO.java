package com.portafolioAgus.portafolio.dto;

import lombok.Getter;

import java.time.LocalDate;


@Getter
public class CertificacionesAplicationDTO {

    private String titulo;

    private String entidadEducativa;

    private LocalDate inicio;

    private LocalDate fin;

    private String imagenCertificado;

    private String nombre;

    private String apellido;
}
