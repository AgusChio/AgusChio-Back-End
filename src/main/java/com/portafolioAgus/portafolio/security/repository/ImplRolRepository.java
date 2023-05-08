package com.portafolioAgus.portafolio.security.repository;


import com.portafolioAgus.portafolio.security.Enums.RolNombre;
import com.portafolioAgus.portafolio.security.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImplRolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
