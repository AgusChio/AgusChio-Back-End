package com.portafolioAgus.portafolio.service;

import com.portafolioAgus.portafolio.dto.RedesSocialesDTO;
import com.portafolioAgus.portafolio.models.RedesSociales;
import com.portafolioAgus.portafolio.repositories.RedesSocialesRepository;
import com.portafolioAgus.portafolio.service.impl.ImplRedesSocialesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RedesSocialesServicies implements ImplRedesSocialesService {

    @Autowired
    RedesSocialesRepository redesSocialesRepository;


    @Override
    public List<RedesSociales> findAllRedesSociales() {
        return redesSocialesRepository.findAll();
    }

    @Override
    public List<RedesSocialesDTO> listRedesSocialesToListRedesSocialesDTO(List<RedesSociales> redesSociales) {
        return redesSocialesRepository.findAll().stream().map(redesSociales1 -> new RedesSocialesDTO(redesSociales1)).collect(Collectors.toList());
    }

    @Override
    public RedesSocialesDTO redesSocialesToRedesSocialesDTO(RedesSociales redesSociales) {
        return new RedesSocialesDTO(redesSociales);
    }

    @Override
    public RedesSociales findByIdRedesSociales(Long id) {
        return redesSocialesRepository.findById(id).orElse(null);
    }

    @Override
    public RedesSociales UpdateRedesSociales(RedesSocialesDTO newRedesSociales) {
        var redesSociales = RedesSociales.builder().build();
        BeanUtils.copyProperties(newRedesSociales, redesSociales);
        return redesSociales;
    }

    @Override
    public void saveRedesSociales(RedesSociales redesSociales) {
        redesSocialesRepository.save(redesSociales);
    }

    @Override
    public void deleteRedesSocialesById(Long id) {
        redesSocialesRepository.deleteById(id);
    }
}
