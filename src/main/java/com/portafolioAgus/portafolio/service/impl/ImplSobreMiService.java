package com.portafolioAgus.portafolio.service.impl;

import com.portafolioAgus.portafolio.dto.SobreMiDTO;
import com.portafolioAgus.portafolio.models.SobreMi;

import java.util.List;

public interface ImplSobreMiService {
    List<SobreMi> findAllsobreMi();

    List<SobreMiDTO> listSobreMiToListSobreMiDTO(List<SobreMi> sobreMi);

    SobreMiDTO sobreMiToSobreMiDTO(SobreMi sobreMi);

    SobreMi findByIdSobreMi(Long id);

    SobreMi updateSobreMi (SobreMiDTO newSobreMi);

    void updateParrafo1(Long id, String parrafo1);

    void updateParrafo2(Long id, String parrafo2);

    void updateCV(Long id, String cv);

    void saveSobreMi(SobreMi sobreMi);

    void deleteSobreMiById(Long id);

}
