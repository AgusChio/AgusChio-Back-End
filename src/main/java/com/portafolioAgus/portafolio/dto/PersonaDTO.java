package com.portafolioAgus.portafolio.dto;

import com.portafolioAgus.portafolio.entity.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Getter
public class PersonaDTO {

    private Long id;

    private String nombre;

    private String apellido;

    private String titulo;

    private String imagen;

    private String descripcion;

    private List<SobreMiDTO> sobreMi;

    private List<ProyectosDTO> proyectos;

    private List<EducacionDTO> certificaciones;

    private List<ServiciosDTO> servicios;

    private List<SkillDTO> skills;


    public PersonaDTO(Persona persona) {
        id = persona.getId();
        nombre = persona.getNombre();
        apellido = persona.getApellido();
        titulo = persona.getTitulo();
        imagen = persona.getImagen();
        descripcion = persona.getDescripcion();
        sobreMi = persona.getSobreMi().stream().map(sobreMi1 -> new SobreMiDTO(sobreMi1)).collect(Collectors.toList());
        proyectos = persona.getProyectos().stream().map(proyecto -> new ProyectosDTO(proyecto)).collect(Collectors.toList());
        certificaciones = persona.getCertificaciones().stream().map(certificacion -> new EducacionDTO(certificacion)).collect(Collectors.toList());
        servicios = persona.getServicios().stream().map(servicio -> new ServiciosDTO(servicio)).collect(Collectors.toList());
        skills = persona.getSkills().stream().map(skills1 -> new SkillDTO(skills1)).collect(Collectors.toList());
    }
}
