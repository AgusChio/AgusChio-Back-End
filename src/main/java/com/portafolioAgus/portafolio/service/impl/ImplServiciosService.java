package com.portafolioAgus.portafolio.service.impl;

import com.portafolioAgus.portafolio.dto.ServiciosDTO;
import com.portafolioAgus.portafolio.entity.Servicios;

import java.util.List;

public interface ImplServiciosService {

    List<Servicios> findAllServicios();

    List<ServiciosDTO> listServiciosToListServiciosDTO(List<Servicios> servicios);

    ServiciosDTO serviciosToServiciosDTO(Servicios servicios);

    Servicios findByIdServicios(Long id);

    Servicios updateServicios (ServiciosDTO newServicios);

    void saveServicios(Servicios servicio);

    void deleteServiciosById(Long id);
}
