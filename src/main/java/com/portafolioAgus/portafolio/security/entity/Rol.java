package com.portafolioAgus.portafolio.security.entity;


import com.portafolioAgus.portafolio.security.Enums.RolNombre;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
