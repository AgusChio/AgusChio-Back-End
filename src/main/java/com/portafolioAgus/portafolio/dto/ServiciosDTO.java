package com.portafolioAgus.portafolio.dto;

import com.portafolioAgus.portafolio.models.Servicios;
import lombok.*;

@Getter
public class ServiciosDTO {
    private Long id;

    private String tituloServicios;

    private String descripcion;

    public ServiciosDTO(Servicios servicios) {
        id = servicios.getId();
        tituloServicios = servicios.getTituloServicio();
        descripcion = servicios.getDescripcion();
    }
}
