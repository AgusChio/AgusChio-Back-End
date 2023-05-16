package com.portafolioAgus.portafolio.controllers;


import com.portafolioAgus.portafolio.dto.ServicioAplicationDTO;
import com.portafolioAgus.portafolio.dto.ServiciosDTO;
import com.portafolioAgus.portafolio.entity.Persona;
import com.portafolioAgus.portafolio.entity.Servicios;
import com.portafolioAgus.portafolio.service.PersonaServicies;
import com.portafolioAgus.portafolio.service.ServiciosServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://main--cheerful-dolphin-8f9864.netlify.app/")
@RequestMapping("/api/servicios")
public class ServiciosController {

    @Autowired
    private ServiciosServicies serviciosServicies;

    @Autowired
    private PersonaServicies personaServicies;

    @GetMapping("/todosServicios")
    public List<ServiciosDTO> listarServicios() {
        return serviciosServicies.listServiciosToListServiciosDTO(serviciosServicies.findAllServicios());
    }

    @GetMapping("/{id}")
    public ServiciosDTO buscarServiciosPorId(@PathVariable Long id) {
        return serviciosServicies.serviciosToServiciosDTO(serviciosServicies.findByIdServicios(id));
    }


    @PostMapping("/agregar")
    public ResponseEntity<?> agregarProyectos(@RequestBody ServicioAplicationDTO servicioAplicationDTO) {
        String nombre = servicioAplicationDTO.getNombre();
        String apellido = servicioAplicationDTO.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (servicioAplicationDTO.getTituloServicio().isEmpty()){
            new ResponseEntity<>("Titulo del servicio vacio", HttpStatus.FORBIDDEN);
        }

        if (servicioAplicationDTO.getDescripcion().isEmpty()){
            new ResponseEntity<>("Descripcion vacia", HttpStatus.FORBIDDEN);
        }

        if (persona == null){
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        Servicios servicioNuevo = new Servicios(servicioAplicationDTO.getTituloServicio(), servicioAplicationDTO.getDescripcion(), persona);
        serviciosServicies.saveServicios(servicioNuevo);

        return new ResponseEntity<>("Servicio Creado", HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarServicios(@PathVariable Long id, @RequestBody ServicioAplicationDTO servicios) {
        Servicios servicioActulizado = serviciosServicies.findByIdServicios(id);

        String nombre = servicios.getNombre();
        String apellido = servicios.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (servicios.getTituloServicio().isEmpty()){
            new ResponseEntity<>("Titulo del servicio vacio", HttpStatus.FORBIDDEN);
        }

        if (servicios.getDescripcion().isEmpty()){
            new ResponseEntity<>("Descripcion vacia", HttpStatus.FORBIDDEN);
        }

        if (persona == null){
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        servicioActulizado.setTituloServicio(servicios.getTituloServicio());
        servicioActulizado.setDescripcion(servicios.getDescripcion());

        serviciosServicies.saveServicios(servicioActulizado);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        serviciosServicies.deleteServiciosById(id);
        return new ResponseEntity<>("Servicio Eliminado" , HttpStatus.ACCEPTED);
    }
}
