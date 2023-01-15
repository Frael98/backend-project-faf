package com.frael.federacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frael.federacion.model.Secretario;

public interface ISecretarioRepository extends JpaRepository<Secretario, Integer>{
    
}
