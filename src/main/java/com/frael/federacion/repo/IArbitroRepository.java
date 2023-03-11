package com.frael.federacion.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frael.federacion.model.Arbitro;

public interface IArbitroRepository extends JpaRepository<Arbitro, Integer>{
    
    public Optional<Arbitro> findByUsuario(String user);
}
