package com.portafolioAgus.portafolio.security.service;


import com.portafolioAgus.portafolio.security.entity.Usuario;
import com.portafolioAgus.portafolio.security.repository.ImplUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    ImplUsuarioRepositorio implUsuarioRepositorio;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return  implUsuarioRepositorio.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return implUsuarioRepositorio.existsByNombreUsuario(nombreUsuario);
    }


    public boolean existsByEmail(String email){
        return implUsuarioRepositorio.existsByEmail(email);
    }

    public void  save(Usuario usuario){
        implUsuarioRepositorio.save(usuario);
    }

}
