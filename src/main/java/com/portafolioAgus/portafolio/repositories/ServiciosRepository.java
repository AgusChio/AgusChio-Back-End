package com.portafolioAgus.portafolio.repositories;

import com.portafolioAgus.portafolio.entity.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Long> {
}
