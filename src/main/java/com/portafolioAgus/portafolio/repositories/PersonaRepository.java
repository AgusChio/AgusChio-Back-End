package com.portafolioAgus.portafolio.repositories;


import com.portafolioAgus.portafolio.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    List<Persona> findByNombreAndApellido(String nombre, String apellido);


}
