package com.portafolioAgus.portafolio.controllers;

import com.portafolioAgus.portafolio.dto.SobreMiAplicationDTO;
import com.portafolioAgus.portafolio.dto.SobreMiDTO;
import com.portafolioAgus.portafolio.entity.Persona;
import com.portafolioAgus.portafolio.entity.SobreMi;
import com.portafolioAgus.portafolio.service.PersonaServicies;
import com.portafolioAgus.portafolio.service.SobreMiServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sobreMi")
public class SobreMiController {

    @Autowired
    SobreMiServicies sobreMiServicies;

    @Autowired
    private PersonaServicies personaServicies;


    @GetMapping("/todoSobreMi")
    public List<SobreMiDTO> listadoSobreMi() {
        return sobreMiServicies.listSobreMiToListSobreMiDTO(sobreMiServicies.findAllsobreMi());
    }

    @GetMapping("/{id}")
    public SobreMiDTO buscarSobreMiPorId(@PathVariable Long id) {
        return sobreMiServicies.sobreMiToSobreMiDTO(sobreMiServicies.findByIdSobreMi(id));
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> createSobreMi(@RequestBody SobreMiAplicationDTO sobreMi) {
        String nombre = sobreMi.getNombre();
        String apellido = sobreMi.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (sobreMi.getParrafo1().isEmpty()){
            new ResponseEntity<>("Parrafo vacio", HttpStatus.FORBIDDEN);
        }

        if (sobreMi.getParrafo2().isEmpty()){
            new ResponseEntity<>("Parrafo vacio", HttpStatus.FORBIDDEN);
        }

        if (persona == null){
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        SobreMi sobreMiNuevo = new SobreMi(sobreMi.getParrafo1(), sobreMi.getParrafo2(), sobreMi.getCv(), persona);
        sobreMiServicies.saveSobreMi(sobreMiNuevo);

        return new ResponseEntity<>("Sobre Mi Creado", HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarSobreMiCompleto(@PathVariable Long id, @RequestBody SobreMiAplicationDTO sobreMi) {
        SobreMi sobreMiActualizado = sobreMiServicies.findByIdSobreMi(id);

        String nombre = sobreMi.getNombre();
        String apellido = sobreMi.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (sobreMi.getParrafo1().isEmpty()){
            new ResponseEntity<>("Parrafo vacio", HttpStatus.FORBIDDEN);
        }

        if (sobreMi.getParrafo2().isEmpty()){
            new ResponseEntity<>("Parrafo vacio", HttpStatus.FORBIDDEN);
        }

        if (sobreMi.getCv().isEmpty()){
            new ResponseEntity<>("Cv vacio, se puede poner que no tiene", HttpStatus.FORBIDDEN);
        }

        if (persona == null){
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        sobreMiActualizado.setCv(sobreMi.getCv());
        sobreMiActualizado.setParrafo1(sobreMi.getParrafo1());
        sobreMiActualizado.setParrafo2(sobreMi.getParrafo2());

        sobreMiServicies.saveSobreMi(sobreMiActualizado);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deleteSobreMiById(@PathVariable Long id) {
        sobreMiServicies.deleteSobreMiById(id);
        return new ResponseEntity<>("Sobre Mi Eliminado" , HttpStatus.ACCEPTED);
    }

}
