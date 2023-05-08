package com.portafolioAgus.portafolio.dto;

import com.portafolioAgus.portafolio.models.SobreMi;
import lombok.*;

@Getter
public class SobreMiDTO {
    private Long id;

    private String parrafo1;

    private String parrafo2;

    private String cv;

    public SobreMiDTO(SobreMi sobreMi) {
        id = sobreMi.getId();
        parrafo1 = sobreMi.getParrafo1();
        parrafo2 = sobreMi.getParrafo2();
        cv = sobreMi.getCv();
    }
}
