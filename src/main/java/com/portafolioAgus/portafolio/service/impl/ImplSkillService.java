package com.portafolioAgus.portafolio.service.impl;

import com.portafolioAgus.portafolio.dto.SkillDTO;
import com.portafolioAgus.portafolio.entity.Skills;

import java.util.List;

public interface ImplSkillService {

    public List<Skills> findAllSkills();

    List<SkillDTO> listSkillToListSkillDTO(List<Skills> skill);

    SkillDTO skillToSkillDTO(Skills skills);

    public Skills findSkillsById(Long id);

    public void saveSkills(Skills skills);

    public void deleteSkills(Long id);




}
