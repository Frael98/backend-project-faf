package com.frael.federacion.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.frael.federacion.model.Administrador;

public interface IAdministradorRepository extends JpaRepository<Administrador, Integer> {
    
    public Optional<Administrador> findByUsuario(String usuario);

}
