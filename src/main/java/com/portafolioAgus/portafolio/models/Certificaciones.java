package com.portafolioAgus.portafolio.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor // este es mi constructor vacio por defecto de lombok
@AllArgsConstructor // crea el constructor con los argumentos
@Builder
@Entity
public class Certificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private String entidadEducativa;

    private LocalDate inicio;

    private LocalDate fin;

    private String imagenCertificado;

    @ManyToOne
    private Persona persona;

    public Certificaciones(String titulo, String entidadEducativa, LocalDate inicio, LocalDate fin, String imagenCertificado, Persona persona) {
        this.titulo = titulo;
        this.entidadEducativa = entidadEducativa;
        this.inicio = inicio;
        this.fin = fin;
        this.imagenCertificado = imagenCertificado;
        this.persona = persona;
    }
}
