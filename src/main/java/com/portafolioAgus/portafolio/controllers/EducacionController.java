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

@RestController
@RequestMapping("/api/certificaciones")
public class EducacionController {

    @Autowired
    private EducacionServicies educacionServicies;

    @Autowired
    private PersonaServicies personaServicies;


    @GetMapping("/todasCertificaciones")
    public List<EducacionDTO> listadoCertificaciones(){
        return educacionServicies.listCertificacionToListCertificacionesDTO(educacionServicies.findAllCertificaciones());
    }

    @GetMapping("/{id}")
    public EducacionDTO buscarCertificacionPorId(@PathVariable Long id) {
        return educacionServicies.certificacionesToCertificacionesDTO(educacionServicies.findByIdCertificaciones(id));
    }


    @PostMapping("/agregar")
    public ResponseEntity<?> agregarCertificaciones(@RequestBody EducacionAplicationDTO certificaciones){

        String nombre = certificaciones.getNombre();
        String apellido = certificaciones.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);


        if (certificaciones.getEntidadEducativa().isEmpty()){
            return new ResponseEntity<>("Nombre de la entidad educativa vacia", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getInicio() == null){
            return new ResponseEntity<>("Fecha de inicio vacia", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getFin() == null){
            return new ResponseEntity<>("Fecha de fin vacia", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getInicio().equals(certificaciones.getFin()) || certificaciones.getFin().equals(certificaciones.getInicio())){
            return new ResponseEntity<>("La fecha de inicio no puede ser igual a la fecha final o viceversa", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getInicio().isAfter(certificaciones.getFin())){
            return new ResponseEntity<>("La fecha inicial no puede ser posterior a la fecha final", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getFin().isBefore(certificaciones.getInicio())){
            return new ResponseEntity<>("La fecha final no puede ser antes a la fecha inicial", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getTitulo().isEmpty()){
            return new ResponseEntity<>("El título esta vacio", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getImagenCertificado().isEmpty()){
            return new ResponseEntity<>("La imagen esta vacia", HttpStatus.FORBIDDEN);
        }

        if (persona == null) {
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        Educacion nuevaCertificacion = new Educacion(certificaciones.getTitulo(), certificaciones.getEntidadEducativa(),certificaciones.getInicio(),certificaciones.getFin(), certificaciones.getImagenCertificado(), persona);
        educacionServicies.saveCertificaciones(nuevaCertificacion);

        return new ResponseEntity<>("Certificado Creado", HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarCertificaciones(@PathVariable Long id, @RequestBody EducacionAplicationDTO certificaciones){

        Educacion educacionActualizada = educacionServicies.findByIdCertificaciones(id);
        String nombre = certificaciones.getNombre();
        String apellido = certificaciones.getApellido();
        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if (certificaciones.getEntidadEducativa().isEmpty()){
            return new ResponseEntity<>("Nombre de la entidad educativa vacia", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getInicio() == null){
            return new ResponseEntity<>("Fecha de inicio vacia", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getFin() == null){
            return new ResponseEntity<>("Fecha de fin vacia", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getInicio().equals(certificaciones.getFin()) || certificaciones.getFin().equals(certificaciones.getInicio())){
            return new ResponseEntity<>("La fecha de inicio no puede ser igual a la fecha final o viceversa", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getInicio().isAfter(certificaciones.getFin())){
            return new ResponseEntity<>("La fecha inicial no puede ser posterior a la fecha final", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getFin().isBefore(certificaciones.getInicio())){
            return new ResponseEntity<>("La fecha final no puede ser antes a la fecha inicial", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getTitulo().isEmpty()){
            return new ResponseEntity<>("El título esta vacio", HttpStatus.FORBIDDEN);
        }

        if (certificaciones.getImagenCertificado().isEmpty()){
            return new ResponseEntity<>("La imagen esta vacia", HttpStatus.FORBIDDEN);
        }

        if (persona == null) {
            return new ResponseEntity<>("No se encontró la persona correspondiente al nombre y apellido proporcionados", HttpStatus.FORBIDDEN);
        }

        educacionActualizada.setTitulo(certificaciones.getTitulo());
        educacionActualizada.setEntidadEducativa(certificaciones.getEntidadEducativa());
        educacionActualizada.setInicio(certificaciones.getInicio());
        educacionActualizada.setFin(certificaciones.getFin());
        educacionActualizada.setImagenCertificado(educacionActualizada.getImagenCertificado());
        educacionActualizada.setPersona(persona);

        educacionServicies.saveCertificaciones(educacionActualizada);

        return new ResponseEntity<>("Certificaciones Actualizada", HttpStatus.CREATED);
    }


    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarCertificacion(@PathVariable Long id) {
        educacionServicies.deleteCertificacionesById(id);
        return new ResponseEntity<>("Certificacion Eliminada", HttpStatus.ACCEPTED);
    }
}
