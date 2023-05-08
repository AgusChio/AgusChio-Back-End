package com.portafolioAgus.portafolio.dto;

import com.portafolioAgus.portafolio.models.RedesSociales;
import lombok.*;

@Getter
public class RedesSocialesDTO {
    private Long id;

    private String urlIcon;

    private String nombreRedSocial;

    private String urlRedSocial;


    public RedesSocialesDTO(RedesSociales redesSociales) {
        id = redesSociales.getId();
        urlIcon = redesSociales.getUrlIcon();
        nombreRedSocial = redesSociales.getNombreRedSocial();
        urlRedSocial = redesSociales.getUrlRedSocial();
    }
}
