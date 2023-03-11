package com.frael.federacion.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.frael.federacion.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    public Optional<Usuario> findByUsuario(String usuario);

}
