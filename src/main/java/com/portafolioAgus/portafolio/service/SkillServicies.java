package com.portafolioAgus.portafolio.service;

import com.portafolioAgus.portafolio.dto.SkillDTO;
import com.portafolioAgus.portafolio.entity.Skills;
import com.portafolioAgus.portafolio.repositories.SkillRepository;
import com.portafolioAgus.portafolio.service.impl.ImplSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SkillServicies implements ImplSkillService {

    @Autowired
    SkillRepository skillRepository;


    @Override
    public List<Skills> findAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public List<SkillDTO> listSkillToListSkillDTO(List<Skills> skill) {
        return skillRepository.findAll().stream().map(skill1 -> new SkillDTO(skill1)).collect(Collectors.toList());
    }

    @Override
    public SkillDTO skillToSkillDTO(Skills skills) {
        return new SkillDTO(skills);
    }

    @Override
    public Skills findSkillsById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSkills(Skills skills) {
        skillRepository.save(skills);
    }

    @Override
    public void deleteSkills(Long id) {
        skillRepository.deleteById(id);
    }
}
