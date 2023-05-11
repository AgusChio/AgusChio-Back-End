package com.portafolioAgus.portafolio.repositories;

import com.portafolioAgus.portafolio.entity.SobreMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobreMiRepository extends JpaRepository<SobreMi, Long> {
}
