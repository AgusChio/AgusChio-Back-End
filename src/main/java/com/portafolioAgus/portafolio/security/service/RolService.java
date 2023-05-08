package com.portafolioAgus.portafolio.security.service;


import com.portafolioAgus.portafolio.security.Enums.RolNombre;
import com.portafolioAgus.portafolio.security.entity.Rol;
import com.portafolioAgus.portafolio.security.repository.ImplRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    ImplRolRepository implRolRepositoryrolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return implRolRepositoryrolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        implRolRepositoryrolRepository.save(rol);
    }


}
