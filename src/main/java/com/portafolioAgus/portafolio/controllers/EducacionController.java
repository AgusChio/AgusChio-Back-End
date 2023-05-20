package com.portafolioAgus.portafolio.controllers;

import com.portafolioAgus.portafolio.dto.EducacionAplicationDTO;
import com.portafolioAgus.portafolio.dto.EducacionDTO;
import com.portafolioAgus.portafolio.entity.Educacion;
import com.portafolioAgus.portafolio.entity.Persona;
import com.portafolioAgus.portafolio.service.EducacionServicies;
import com.portafolioAgus.portafolio.service.PersonaServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://main--cheerful-dolphin-8f9864.netlify.app/")
@RestController
@RequestMapping("/api/educacion")
public class EducacionController {

    @Autowired
    private EducacionServicies educacionServicies;

    @Autowired
    private PersonaServicies personaServicies;


    @GetMapping("/todasEducaciones")
    public List<EducacionDTO> listadoEducacion(){
        return educacionServicies.listEducacionToListEducacionDTO(educacionServicies.findAllEducacion());
    }

    @GetMapping("/{id}")
    public EducacionDTO buscarEducacionPorId(@PathVariable Long id) {
        return educacionServicies.EducacionToEducacionDTO(educacionServicies.findByIdEducacion(id));
    }


    @PostMapping("/agregar")
    public ResponseEntity<?> agregarEducacion(@RequestBody EducacionAplicationDTO educacion){

        String nombre = educacion.getNombre();
        String apellido = educacion.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (educacion.getEntidadEducativa().isEmpty()){
            return new ResponseEntity<>("Nombre de la entidad educativa vacia", HttpStatus.FORBIDDEN);
        }

        if (educacion.getInicio().isEmpty()){
            return new ResponseEntity<>("Fecha de inicio vacia", HttpStatus.FORBIDDEN);
        }

        if (educacion.getFin().isEmpty()){
            return new ResponseEntity<>("Fecha de fin vacia", HttpStatus.FORBIDDEN);
        }

        if (educacion.getInicio().equals(educacion.getFin()) || educacion.getFin().equals(educacion.getInicio())){
            return new ResponseEntity<>("La fecha de inicio no puede ser igual a la fecha final o viceversa", HttpStatus.FORBIDDEN);
        }

        if (educacion.getTitulo().isEmpty()){
            return new ResponseEntity<>("El título esta vacio", HttpStatus.FORBIDDEN);
        }

        if (educacion.getImagenCertificado().isEmpty()){
            return new ResponseEntity<>("La imagen esta vacia", HttpStatus.FORBIDDEN);
        }

        if (persona == null) {
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        Educacion nuevaEducacion = new Educacion(educacion.getTitulo(), educacion.getEntidadEducativa(),educacion.getInicio(),educacion.getFin(), educacion.getImagenCertificado(), persona);
        educacionServicies.saveEducacion(nuevaEducacion);

        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarEducacion(@PathVariable Long id, @RequestBody EducacionAplicationDTO educacion){

        Educacion educacionActualizada = educacionServicies.findByIdEducacion(id);
        String nombre = educacion.getNombre();
        String apellido = educacion.getApellido();
        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (educacion.getEntidadEducativa().isEmpty()){
            return new ResponseEntity<>("Nombre de la entidad educativa vacia", HttpStatus.FORBIDDEN);
        }

        if (educacion.getInicio().isEmpty()){
            return new ResponseEntity<>("Fecha de inicio vacia", HttpStatus.FORBIDDEN);
        }

        if (educacion.getFin().isEmpty()){
            return new ResponseEntity<>("Fecha de fin vacia", HttpStatus.FORBIDDEN);
        }

        if (educacion.getInicio().equals(educacion.getFin()) || educacion.getFin().equals(educacion.getInicio())){
            return new ResponseEntity<>("La fecha de inicio no puede ser igual a la fecha final o viceversa", HttpStatus.FORBIDDEN);
        }

        if (educacion.getTitulo().isEmpty()){
            return new ResponseEntity<>("El título esta vacio", HttpStatus.FORBIDDEN);
        }

        if (educacion.getImagenCertificado().isEmpty()){
            return new ResponseEntity<>("La imagen esta vacia", HttpStatus.FORBIDDEN);
        }

        if (persona == null) {
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        educacionActualizada.setTitulo(educacion.getTitulo());
        educacionActualizada.setEntidadEducativa(educacion.getEntidadEducativa());
        educacionActualizada.setInicio(educacion.getInicio());
        educacionActualizada.setFin(educacion.getFin());
        educacionActualizada.setImagenCertificado(educacionActualizada.getImagenCertificado());
        educacionActualizada.setPersona(persona);

        educacionServicies.saveEducacion(educacionActualizada);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarCertificacion(@PathVariable Long id) {
        educacionServicies.deleteEducacionById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
