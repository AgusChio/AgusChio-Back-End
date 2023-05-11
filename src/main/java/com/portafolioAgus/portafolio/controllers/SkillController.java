package com.portafolioAgus.portafolio.controllers;


import com.portafolioAgus.portafolio.dto.SkillApplicationDTO;
import com.portafolioAgus.portafolio.dto.SkillDTO;
import com.portafolioAgus.portafolio.entity.Persona;
import com.portafolioAgus.portafolio.entity.Skills;
import com.portafolioAgus.portafolio.service.PersonaServicies;
import com.portafolioAgus.portafolio.service.SkillServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    SkillServicies skillServicies;

    @Autowired
    private PersonaServicies personaServicies;

    @GetMapping("/todasSkills")
    public List<SkillDTO> listadoSkills(){
        return skillServicies.listSkillToListSkillDTO(skillServicies.findAllSkills());
    }

    @GetMapping("/{id}")
    public SkillDTO buscarSkillsPorId(@PathVariable Long id){
        return skillServicies.skillToSkillDTO(skillServicies.findSkillsById(id));
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> createSkill(@RequestBody SkillApplicationDTO skill){
        String nombre = skill.getNombre();
        String apellido = skill.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if(skill.getNombreSkill().isEmpty()){
            new ResponseEntity<>("Nombre de la Skill Vacio", HttpStatus.FORBIDDEN);
        }

        if (skill.getImgsrc().isEmpty()){
            new ResponseEntity<>("El input de imagen se encuentra vacio", HttpStatus.FORBIDDEN);
        }

        if (skill.getPorcentaje() >= 0){
            new ResponseEntity<>("No se ha ingresado el porcentaje", HttpStatus.FORBIDDEN);
        }

        if (skill.getTypeSkills().equals(null)){
            new ResponseEntity<>("Porfavor ingrese si es una Hard o un Soft skill", HttpStatus.FORBIDDEN);
        }

        if (skill.getColorInterno().isEmpty() || skill.getColorExterno().isEmpty()) {
            new ResponseEntity<>("Porfavor ingrese los colores", HttpStatus.FORBIDDEN);
        }

        Skills skillsNuevo = new Skills(skill.getNombreSkill(), skill.getPorcentaje(), skill.getImgsrc(), skill.getColorInterno(), skill.getColorExterno(),skill.getTypeSkills(), persona);
        skillServicies.saveSkills(skillsNuevo);

        return new ResponseEntity<>("Skill creada", HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarSkill(@PathVariable Long id, @RequestBody SkillApplicationDTO skill){
        Skills skillActualizada = skillServicies.findSkillsById(id);

        String nombre = skill.getNombre();
        String apellido = skill.getApellido();

        Persona persona = personaServicies.buscarPorNombreYApellido(nombre, apellido);

        if(skill.getNombreSkill().isEmpty()){
            new ResponseEntity<>("Nombre de la Skill Vacio", HttpStatus.FORBIDDEN);
        }

        if (skill.getImgsrc().isEmpty()){
            new ResponseEntity<>("El input de imagen se encuentra vacio", HttpStatus.FORBIDDEN);
        }

        if (skill.getPorcentaje() >= 0){
            new ResponseEntity<>("No se ha ingresado el porcentaje", HttpStatus.FORBIDDEN);
        }

        if (skill.getTypeSkills().equals(null)){
            new ResponseEntity<>("Porfavor ingrese si es una Hard o un Soft skill", HttpStatus.FORBIDDEN);
        }

        if (skill.getColorInterno().isEmpty() || skill.getColorExterno().isEmpty()) {
            new ResponseEntity<>("Porfavor ingrese los colores", HttpStatus.FORBIDDEN);
        }

        skillActualizada.setNombreSkill(skill.getNombreSkill());
        skillActualizada.setPorcentaje(skill.getPorcentaje());
        skillActualizada.setImgsrc(skill.getImgsrc());
        skillActualizada.setColorExterno(skill.getColorExterno());
        skillActualizada.setColorInterno(skill.getColorInterno());

        skillServicies.saveSkills(skillActualizada);

        return new ResponseEntity<>("Skill Actualizada", HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deleteSkillById(@PathVariable Long id) {
        skillServicies.deleteSkills(id);
        return new ResponseEntity<>("Skill Eliminada" , HttpStatus.ACCEPTED);
    }
}
