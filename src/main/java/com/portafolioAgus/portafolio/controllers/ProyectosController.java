package com.portafolioAgus.portafolio.controllers;


import com.portafolioAgus.portafolio.dto.ProyectosAplicationDTO;
import com.portafolioAgus.portafolio.dto.ProyectosDTO;
import com.portafolioAgus.portafolio.models.Persona;
import com.portafolioAgus.portafolio.models.Proyectos;
import com.portafolioAgus.portafolio.service.PersonaServicies;
import com.portafolioAgus.portafolio.service.ProyectosServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/proyectos")
public class ProyectosController {

    @Autowired
    private ProyectosServicies proyectosServicies;

    @Autowired
    private PersonaServicies personaServicies;

    @GetMapping("/todosProyectos")
    public List<ProyectosDTO> listarProyectos() {
        return proyectosServicies.listProyectosToListProyectosDTO(proyectosServicies.findAllProyectos());
    }

    @GetMapping("/{id}")
    public ProyectosDTO buscarProyectosPorId(@PathVariable Long id) {
        return proyectosServicies.proyectosToProyectosDTO(proyectosServicies.findByIdProyectos(id));
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarProyecto(@RequestBody ProyectosAplicationDTO proyectos){

        String nombre = proyectos.getNombre();
        String apellido = proyectos.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (proyectos.getNombreProyecto().isEmpty()){
            new ResponseEntity<>("Nombre del proyecto vacio", HttpStatus.FORBIDDEN);
        }

        if (proyectos.getImagen().isEmpty()){
            new ResponseEntity<>("Imagen vacia", HttpStatus.FORBIDDEN);
        }

        if (proyectos.getUrlVideo().isEmpty()){
            new ResponseEntity<>("La url no puede estar vacia, como minimo puede decir que no tiene url", HttpStatus.FORBIDDEN);
        }

        if (proyectos.getUrlDeploy().isEmpty()){
            new ResponseEntity<>("La url no puede estar vacia, como minimo puede decir que no tiene url", HttpStatus.FORBIDDEN);
        }

        if (proyectos.getUrlGitHub().isEmpty()){
            new ResponseEntity<>("La url no puede estar vacia, como minimo puede decir que no tiene url", HttpStatus.FORBIDDEN);
        }

        if (persona == null) {
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        Proyectos proyectoNuevo = new Proyectos(proyectos.getNombreProyecto(), proyectos.getImagen(), proyectos.getUrlVideo(), proyectos.getUrlGitHub(), proyectos.getUrlDeploy(), persona);
        proyectosServicies.saveProyectos(proyectoNuevo);

        return new ResponseEntity<>("Proyecto Creado", HttpStatus.CREATED);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarPoyectos(@PathVariable Long id, @RequestBody ProyectosAplicationDTO proyectos){
        Proyectos proyectoActualizado = proyectosServicies.findByIdProyectos(id);

        String nombre = proyectos.getNombre();
        String apellido = proyectos.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (proyectos.getNombreProyecto().isEmpty()){
            new ResponseEntity<>("Nombre del proyecto vacio", HttpStatus.FORBIDDEN);
        }

        if (proyectos.getImagen().isEmpty()){
            new ResponseEntity<>("Imagen vacia", HttpStatus.FORBIDDEN);
        }

        if (proyectos.getUrlVideo().isEmpty()){
            new ResponseEntity<>("La url no puede estar vacia, como minimo puede decir que no tiene url", HttpStatus.FORBIDDEN);
        }

        if (proyectos.getUrlDeploy().isEmpty()){
            new ResponseEntity<>("La url no puede estar vacia, como minimo puede decir que no tiene url", HttpStatus.FORBIDDEN);
        }

        if (proyectos.getUrlGitHub().isEmpty()){
            new ResponseEntity<>("La url no puede estar vacia, como minimo puede decir que no tiene url", HttpStatus.FORBIDDEN);
        }

        if (persona == null) {
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        proyectoActualizado.setNombreProyecto(proyectos.getNombreProyecto());
        proyectoActualizado.setImagen(proyectos.getImagen());
        proyectoActualizado.setUrlVideo(proyectos.getUrlVideo());
        proyectoActualizado.setUrlDeploy(proyectos.getUrlDeploy());
        proyectoActualizado.setUrlGitHub(proyectos.getUrlGitHub());
        proyectoActualizado.setPersona(persona);

        proyectosServicies.saveProyectos(proyectoActualizado);

        return new ResponseEntity<>("Proyecto Actualizado" , HttpStatus.CREATED);
    }


    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarProyecto(@PathVariable Long id) {
        proyectosServicies.deleteProyectosById(id);
        return new ResponseEntity<>("Proyecto Eliminado" , HttpStatus.ACCEPTED);
    }
}
