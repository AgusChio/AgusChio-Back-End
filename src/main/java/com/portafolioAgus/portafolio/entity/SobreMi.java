package com.portafolioAgus.portafolio.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor // este es mi constructor vacio por defecto de lombok
@AllArgsConstructor // crea el constructor con los argumentos
@Builder
@Entity
public class SobreMi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 600)
    private String parrafo1;

    @Column(length = 600)
    private String parrafo2;

    private String cv;

    @ManyToOne
    private Persona persona;

    public SobreMi(String parrafo1, String parrafo2, String cv, Persona persona) {
        this.parrafo1 = parrafo1;
        this.parrafo2 = parrafo2;
        this.cv = cv;
        this.persona = persona;
    }
}
