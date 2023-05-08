package com.portafolioAgus.portafolio.models;

import lombok.*;

import javax.persistence.*;

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

    private String urlVideo;

    private String urlGitHub;

    private String urlDeploy;

    @ManyToOne
    private Persona persona;

    public Proyectos(String nombreProyecto, String imagen, String urlVideo, String urlGitHub, String urlDeploy, Persona persona) {
        this.nombreProyecto = nombreProyecto;
        this.imagen = imagen;
        this.urlVideo = urlVideo;
        this.urlGitHub = urlGitHub;
        this.urlDeploy = urlDeploy;
        this.persona = persona;
    }
}
