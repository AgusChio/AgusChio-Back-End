package com.portafolioAgus.portafolio.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor // este es mi constructor vacio por defecto de lombok
@AllArgsConstructor // crea el constructor con los argumentos
@Builder
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 45)
    private String nombre;

    @Column(length = 45)
    private String apellido;

    @Column(length = 45)
    private String titulo;

    private String imagen;

    @Column(length = 400)
    private String descripcion;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, orphanRemoval = true) //orphanRemoval me hace una mejor rendimiento de la BD
    private Set<Proyectos> proyectos = new HashSet<>();

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Certificaciones> certificaciones = new HashSet<>();

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Servicios> servicios = new HashSet<>();

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<RedesSociales> redesSociales = new HashSet<>();

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<SobreMi> sobreMi = new HashSet<>();

    public Persona(String nombre, String apellido, String titulo, String imagen, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }
}
