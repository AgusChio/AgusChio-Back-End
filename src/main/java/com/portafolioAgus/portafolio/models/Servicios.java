package com.portafolioAgus.portafolio.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor // este es mi constructor vacio por defecto de lombok
@AllArgsConstructor // crea el constructor con los argumentos
@Builder
@Entity
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tituloServicio;

    @Column(length = 400)
    private String descripcion;

    @ManyToOne
    private Persona persona;

    public Servicios(String tituloServicio, String descripcion, Persona persona) {
        this.tituloServicio = tituloServicio;
        this.descripcion = descripcion;
        this.persona = persona;
    }
}
