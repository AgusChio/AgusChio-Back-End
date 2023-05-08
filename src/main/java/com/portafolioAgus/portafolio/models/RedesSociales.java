package com.portafolioAgus.portafolio.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor // este es mi constructor vacio por defecto de lombok
@AllArgsConstructor // crea el constructor con los argumentos
@Builder
@Entity
public class RedesSociales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String urlIcon;

    private String nombreRedSocial;

    private String urlRedSocial;

    @ManyToOne
    private Persona persona;

    public RedesSociales(String urlIcon, String nombreRedSocial, String urlRedSocial, Persona persona) {
        this.urlIcon = urlIcon;
        this.nombreRedSocial = nombreRedSocial;
        this.urlRedSocial = urlRedSocial;
        this.persona = persona;
    }
}
