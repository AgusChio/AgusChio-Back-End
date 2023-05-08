package com.portafolioAgus.portafolio.controllers;


import com.portafolioAgus.portafolio.dto.RedesSocialesAplicationDTO;
import com.portafolioAgus.portafolio.dto.RedesSocialesDTO;
import com.portafolioAgus.portafolio.models.Persona;
import com.portafolioAgus.portafolio.models.RedesSociales;
import com.portafolioAgus.portafolio.service.PersonaServicies;
import com.portafolioAgus.portafolio.service.RedesSocialesServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redesSociales")
public class RedesSocialesController {

    @Autowired
    private RedesSocialesServicies redesSocialesServicies;

    @Autowired
    private PersonaServicies personaServicies;

    @GetMapping("/todasRedesSociales")
    public List<RedesSocialesDTO> listarRedesSociales() {
        return redesSocialesServicies.listRedesSocialesToListRedesSocialesDTO(redesSocialesServicies.findAllRedesSociales());
    }

    @GetMapping("/{id}")
    public RedesSocialesDTO buscarRedesSocialesPorId(@PathVariable Long id) {
       return redesSocialesServicies.redesSocialesToRedesSocialesDTO(redesSocialesServicies.findByIdRedesSociales(id));
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarRedSocial(@RequestBody RedesSocialesAplicationDTO redesSociales) {
        String nombre = redesSociales.getNombre();
        String apellido = redesSociales.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (redesSociales.getNombreRedSocial().isEmpty()){
            new ResponseEntity<>("Nombre de la Red Social vacia vacio", HttpStatus.FORBIDDEN);
        }

        if (redesSociales.getUrlRedSocial().isEmpty()){
            new ResponseEntity<>("Url de la red social vacia", HttpStatus.FORBIDDEN);
        }

        if (redesSociales.getUrlIcon().isEmpty()){
            new ResponseEntity<>("Url del icono de la red social vacia", HttpStatus.FORBIDDEN);
        }

        if (persona == null){
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        RedesSociales redSocialNueva = new RedesSociales(redesSociales.getUrlIcon(),redesSociales.getNombreRedSocial(), redesSociales.getUrlRedSocial(), persona);
        redesSocialesServicies.saveRedesSociales(redSocialNueva);

        return new ResponseEntity<>("Red Social Creada", HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarRedesSociales(@PathVariable Long id, @RequestBody RedesSocialesAplicationDTO redesSociales) {
        RedesSociales redSocialActualizada = redesSocialesServicies.findByIdRedesSociales(id);

        String nombre = redesSociales.getNombre();
        String apellido = redesSociales.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (redesSociales.getNombreRedSocial().isEmpty()){
            new ResponseEntity<>("Nombre de la Red Social vacia vacio", HttpStatus.FORBIDDEN);
        }

        if (redesSociales.getUrlRedSocial().isEmpty()){
            new ResponseEntity<>("Url de la red social vacia", HttpStatus.FORBIDDEN);
        }

        if (redesSociales.getUrlIcon().isEmpty()){
            new ResponseEntity<>("Url del icono de la red social vacia", HttpStatus.FORBIDDEN);
        }

        if (persona == null){
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        redSocialActualizada.setNombreRedSocial(redesSociales.getNombreRedSocial());
        redSocialActualizada.setUrlRedSocial(redesSociales.getUrlRedSocial());
        redSocialActualizada.setUrlIcon(redesSociales.getUrlIcon());
        redSocialActualizada.setPersona(persona);

        redesSocialesServicies.saveRedesSociales(redSocialActualizada);

        return new ResponseEntity<>("Red Social Actualizada", HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarRedesSociales(@PathVariable Long id) {
        redesSocialesServicies.deleteRedesSocialesById(id);
        return new ResponseEntity<>("Red Social Eliminada" , HttpStatus.ACCEPTED);
    }

}
