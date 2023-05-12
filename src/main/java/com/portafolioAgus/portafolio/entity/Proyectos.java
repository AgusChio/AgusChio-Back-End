package com.portafolioAgus.portafolio.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor // este es mi constructor vacio por defecto de lombok
@AllArgsConstructor // crea el constructor con los argumentos
@Builder
@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 45)
    private String nombreProyecto;

    private String imagen;

    private String descripcion;

    private LocalDate fechaRealizacion;
    private String urlVideo;

    private String urlGitHub;

    private String urlDeploy;

    @ManyToOne
    private Persona persona;

    public Proyectos(String nombreProyecto, String imagen, String descripcion,LocalDate fechaRealizacion ,String urlVideo, String urlGitHub, String urlDeploy, Persona persona) {
        this.nombreProyecto = nombreProyecto;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.fechaRealizacion = fechaRealizacion;
        this.urlVideo = urlVideo;
        this.urlGitHub = urlGitHub;
        this.urlDeploy = urlDeploy;
        this.persona = persona;
    }
}
