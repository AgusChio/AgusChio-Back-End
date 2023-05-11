package com.portafolioAgus.portafolio.dto;

import com.portafolioAgus.portafolio.Utils.Enums.TypeSkills;
import com.portafolioAgus.portafolio.entity.Skills;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;


@Getter
public class SkillDTO {
    private Long id;

    private String nombreSkill;

    private int porcentaje;

    private String imgsrc;

    private String colorInterno;

    private String colorExterno;

    private TypeSkills typeSkills;

    public SkillDTO(Skills skills) {
        id = skills.getId();
        nombreSkill = skills.getNombreSkill();
        porcentaje = skills.getPorcentaje();
        imgsrc = skills.getImgsrc();
        colorInterno = skills.getColorInterno();
        colorExterno = skills.getColorExterno();
        typeSkills = skills.getTypeSkills();
    }
}
