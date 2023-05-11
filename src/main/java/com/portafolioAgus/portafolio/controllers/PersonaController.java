package com.portafolioAgus.portafolio.controllers;


import com.portafolioAgus.portafolio.dto.PersonaDTO;
import com.portafolioAgus.portafolio.entity.Persona;
import com.portafolioAgus.portafolio.service.PersonaServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaServicies personaServicies;

    @GetMapping("/todasPersonas")
    public List<PersonaDTO> listarPersonas() {
        return personaServicies.ListpersonatoListPersonaDTO();
    }

    @GetMapping("/{id}")
    public PersonaDTO buscarPersonaPorId(@PathVariable Long id) {
        return personaServicies.personaToPersonaDTO(personaServicies.findByIdPersona(id));
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarPersona(@RequestBody Persona persona){
        if (persona.getNombre().isEmpty()){
            return new ResponseEntity<>("Nombre vacio", HttpStatus.FORBIDDEN);
        }

        if (persona.getApellido().isEmpty()){
            return new ResponseEntity<>("Apellido vacio", HttpStatus.FORBIDDEN);
        }

        if (persona.getTitulo().isEmpty()){
            new ResponseEntity<>("Título vacio", HttpStatus.FORBIDDEN);
        }

        if (persona.getImagen().isEmpty()){
            new ResponseEntity<>("Imagen vacia", HttpStatus.FORBIDDEN);
        }

        if (persona.getDescripcion().isEmpty()){
            new ResponseEntity<>("Descripción vacia", HttpStatus.FORBIDDEN);
        }

        Persona personaNueva = new Persona(persona.getNombre(), persona.getApellido(), persona.getTitulo(), persona.getImagen(), persona.getDescripcion());
        personaServicies.savePersona(personaNueva);

        return new ResponseEntity<>("Persona Creada", HttpStatus.CREATED);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarPersona(@PathVariable Long id, @RequestBody Persona persona){
        Persona personaActualizada = personaServicies.findByIdPersona(id);

        if (persona.getNombre().isEmpty()){
            return new ResponseEntity<>("Nombre vacio", HttpStatus.FORBIDDEN);
        }

        if (persona.getApellido().isEmpty()){
            return new ResponseEntity<>("Apellido vacio", HttpStatus.FORBIDDEN);
        }

        if (persona.getTitulo().isEmpty()){
            new ResponseEntity<>("Título vacio", HttpStatus.FORBIDDEN);
        }

        if (persona.getImagen().isEmpty()){
            new ResponseEntity<>("Imagen vacia", HttpStatus.FORBIDDEN);
        }

        if (persona.getDescripcion().isEmpty()){
            new ResponseEntity<>("Descripción vacia", HttpStatus.FORBIDDEN);
        }

        personaActualizada.setNombre(persona.getNombre());
        personaActualizada.setApellido(persona.getApellido());
        personaActualizada.setTitulo(persona.getTitulo());
        personaActualizada.setImagen(persona.getImagen());
        personaActualizada.setDescripcion(persona.getDescripcion());

        personaServicies.savePersona(personaActualizada);

        return new ResponseEntity<>("Persona Actualizada", HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable Long id){
        personaServicies.deletePersonaById(id);
        return new ResponseEntity<>("Persona Eliminada", HttpStatus.ACCEPTED);
    }


}
