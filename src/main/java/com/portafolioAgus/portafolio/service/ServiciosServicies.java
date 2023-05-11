package com.portafolioAgus.portafolio.service;


import com.portafolioAgus.portafolio.dto.ServiciosDTO;
import com.portafolioAgus.portafolio.entity.Servicios;
import com.portafolioAgus.portafolio.repositories.ServiciosRepository;
import com.portafolioAgus.portafolio.service.impl.ImplServiciosService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ServiciosServicies implements ImplServiciosService {

    @Autowired
    ServiciosRepository serviciosRepository;

    @Override
    public List<Servicios> findAllServicios() {
        return serviciosRepository.findAll();
    }

    @Override
    public List<ServiciosDTO> listServiciosToListServiciosDTO(List<Servicios> servicios) {
        return serviciosRepository.findAll().stream().map(servicios1 -> new ServiciosDTO(servicios1)).collect(Collectors.toList());
    }

    @Override
    public ServiciosDTO serviciosToServiciosDTO(Servicios servicios) {
        return new ServiciosDTO(servicios);
    }

    @Override
    public  Servicios findByIdServicios(Long id) {
        return serviciosRepository.findById(id).orElse(null);
    }

    @Override
    public Servicios updateServicios(ServiciosDTO newServicios) {
        var servicios = Servicios.builder().build();
        BeanUtils.copyProperties(newServicios, servicios);
        return servicios;
    }

    @Override
    public void saveServicios(Servicios servicio) {
        serviciosRepository.save(servicio);
    }

    @Override
    public void deleteServiciosById(Long id) {
        serviciosRepository.deleteById(id);
    }
}
