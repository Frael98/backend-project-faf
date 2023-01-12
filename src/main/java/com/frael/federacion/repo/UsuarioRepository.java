package com.frael.federacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.frael.federacion.model.Usuario;
// Interfaz de repositorio

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
