package com.portafolioAgus.portafolio.dto;

import lombok.Getter;

@Getter
public class ServicioAplicationDTO {

    private String tituloServicio;

    private String descripcion;

    private String nombre;

    private String apellido;

    public String getTituloServicio() {
        return tituloServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
