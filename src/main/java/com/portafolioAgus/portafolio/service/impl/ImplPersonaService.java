package com.portafolioAgus.portafolio.service.impl;

import com.portafolioAgus.portafolio.dto.PersonaDTO;
import com.portafolioAgus.portafolio.entity.Persona;

import java.util.List;

public interface ImplPersonaService {

    Persona findByIdPersona(Long id);

    PersonaDTO personaToPersonaDTO(Persona persona);

    void savePersona(Persona persona);

    void deletePersonaById(Long id);

    List<Persona> findAllPersona();

    List<PersonaDTO> ListpersonatoListPersonaDTO();

    Persona buscarPorNombreYApellido(String nombre, String apellido);
}
