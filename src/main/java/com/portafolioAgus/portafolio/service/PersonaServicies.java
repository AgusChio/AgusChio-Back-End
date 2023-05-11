package com.portafolioAgus.portafolio.service;

import com.portafolioAgus.portafolio.dto.PersonaDTO;
import com.portafolioAgus.portafolio.entity.Persona;
import com.portafolioAgus.portafolio.repositories.PersonaRepository;
import com.portafolioAgus.portafolio.service.impl.ImplPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonaServicies implements ImplPersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Persona findByIdPersona(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public PersonaDTO personaToPersonaDTO(Persona persona) {
        return new PersonaDTO(persona);
    }

    @Override
    public void savePersona(Persona persona){
        personaRepository.save(persona);
    }


    @Override
    public void deletePersonaById(Long id){
        personaRepository.deleteById(id);
    }

    @Override
    public List<Persona> findAllPersona(){
        return personaRepository.findAll();
    }

    @Override
    public List<PersonaDTO> ListpersonatoListPersonaDTO() {
        return personaRepository.findAll().stream().map(persona -> new PersonaDTO(persona)).collect(Collectors.toList());
    }

    @Override
    public Persona buscarPorNombreYApellido(String nombre, String apellido) {
        List<Persona> personas = personaRepository.findByNombreAndApellido(nombre, apellido);
        if (!personas.isEmpty()) {
            return personas.get(0);
        } else {
            return null;
        }
    }


}
