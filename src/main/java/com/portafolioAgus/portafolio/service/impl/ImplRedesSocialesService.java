package com.portafolioAgus.portafolio.service.impl;

import com.portafolioAgus.portafolio.dto.RedesSocialesDTO;
import com.portafolioAgus.portafolio.models.RedesSociales;

import java.util.List;

public interface ImplRedesSocialesService {

    List<RedesSociales> findAllRedesSociales();

    List<RedesSocialesDTO> listRedesSocialesToListRedesSocialesDTO(List<RedesSociales> redesSociales);

    RedesSocialesDTO redesSocialesToRedesSocialesDTO(RedesSociales redesSociales);

    RedesSociales findByIdRedesSociales(Long id);

    RedesSociales UpdateRedesSociales(RedesSocialesDTO newRedesSociales);

    void saveRedesSociales(RedesSociales redesSociales);

    void deleteRedesSocialesById(Long id);
}
