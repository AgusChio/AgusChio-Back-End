package com.portafolioAgus.portafolio.entity;


import com.portafolioAgus.portafolio.Utils.Enums.TypeSkills;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombreSkill;

    @Range(min = 0, max = 100, message = "Por favor, ingrese valores positivos entre 0 y 100.")
    private int porcentaje;

    @Column(length = 600)
    private String imgsrc;

    @Column(length = 45)
    private String colorInterno;

    @Column(length = 45)
    private String colorExterno;

    private TypeSkills typeSkills;

    @ManyToOne
    private Persona persona;

    public Skills(String nombreSkill, int porcentaje, String imgsrc, String colorInterno, String colorExterno, TypeSkills typeSkills,Persona persona) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
        this.imgsrc = imgsrc;
        this.colorInterno = colorInterno;
        this.colorExterno = colorExterno;
        this.typeSkills = typeSkills;
        this.persona = persona;
    }
}

