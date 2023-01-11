package com.frael.federacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frael.federacion.model.Usuario;
// Interfaz de repositorio
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
