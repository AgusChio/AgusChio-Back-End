package com.portafolioAgus.portafolio.dto;


import com.portafolioAgus.portafolio.Utils.Enums.TypeSkills;
import lombok.Getter;

@Getter
public class SkillApplicationDTO {
    private long id;

    private String nombreSkill;

    private int porcentaje;

    private String imgsrc;

    private String colorInterno;

    private String colorExterno;

    private TypeSkills typeSkills;

    private String nombre;

    private String apellido;
}
