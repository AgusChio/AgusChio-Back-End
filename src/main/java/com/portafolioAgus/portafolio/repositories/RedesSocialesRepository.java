package com.portafolioAgus.portafolio.repositories;

import com.portafolioAgus.portafolio.models.RedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesSocialesRepository extends JpaRepository<RedesSociales, Long> {
}
