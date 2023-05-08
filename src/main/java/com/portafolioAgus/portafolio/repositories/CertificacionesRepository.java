package com.portafolioAgus.portafolio.repositories;

import com.portafolioAgus.portafolio.models.Certificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificacionesRepository extends JpaRepository<Certificaciones, Long> {
}
