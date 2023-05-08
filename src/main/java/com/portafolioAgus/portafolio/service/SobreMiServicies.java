package com.portafolioAgus.portafolio.service;

import com.portafolioAgus.portafolio.dto.SobreMiDTO;
import com.portafolioAgus.portafolio.models.SobreMi;
import com.portafolioAgus.portafolio.repositories.SobreMiRepository;
import com.portafolioAgus.portafolio.service.impl.ImplSobreMiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SobreMiServicies implements ImplSobreMiService {

    @Autowired
    SobreMiRepository sobreMiRepository;

    @Override
    public List<SobreMi> findAllsobreMi() {
        return sobreMiRepository.findAll();
    }

    @Override
    public List<SobreMiDTO> listSobreMiToListSobreMiDTO(List<SobreMi> sobreMi) {
        return sobreMiRepository.findAll().stream().map(sobreMi1 -> new SobreMiDTO(sobreMi1)).collect(Collectors.toList());
    }

    @Override
    public SobreMiDTO sobreMiToSobreMiDTO(SobreMi sobreMi) {
        return new SobreMiDTO(sobreMi);
    }

    @Override
    public SobreMi findByIdSobreMi(Long id) {
        return sobreMiRepository.findById(id).orElse(null);
    }


    @Override
    public SobreMi updateSobreMi(SobreMiDTO newSobreMi) {
        var sobreMi = SobreMi.builder().build();
        BeanUtils.copyProperties(newSobreMi, sobreMi);
        return sobreMi;
    }

    @Override
    public void updateParrafo1(Long id, String parrafo1) {
        SobreMi sobreMi = sobreMiRepository.findById(id).orElse(null);
        if (sobreMi != null) {
            sobreMi.setParrafo1(parrafo1);
            saveSobreMi(sobreMi);
        }
    }

    @Override
    public void updateParrafo2(Long id, String parrafo2) {
        SobreMi sobreMi = sobreMiRepository.findById(id).orElse(null);
        if (sobreMi != null) {
            sobreMi.setParrafo2(parrafo2);
            saveSobreMi(sobreMi);
        }
    }

    @Override
    public void updateCV(Long id, String cv) {
        SobreMi sobreMi = sobreMiRepository.findById(id).orElse(null);
        if (sobreMi != null) {
            sobreMi.setCv(cv);
            saveSobreMi(sobreMi);
        }
    }

    @Override
    public void saveSobreMi(SobreMi sobreMi) {
        sobreMiRepository.save(sobreMi);
    }

    @Override
    public void deleteSobreMiById(Long id) {
        sobreMiRepository.deleteById(id);
    }




}


