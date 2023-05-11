package com.portafolioAgus.portafolio.service.impl;

import com.portafolioAgus.portafolio.dto.SobreMiDTO;
import com.portafolioAgus.portafolio.entity.SobreMi;

import java.util.List;

public interface ImplSobreMiService {
    List<SobreMi> findAllsobreMi();

    List<SobreMiDTO> listSobreMiToListSobreMiDTO(List<SobreMi> sobreMi);

    SobreMiDTO sobreMiToSobreMiDTO(SobreMi sobreMi);

    SobreMi findByIdSobreMi(Long id);

    SobreMi updateSobreMi (SobreMiDTO newSobreMi);

    void saveSobreMi(SobreMi sobreMi);

    void deleteSobreMiById(Long id);

}
