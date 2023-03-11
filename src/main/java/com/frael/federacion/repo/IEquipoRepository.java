package com.frael.federacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frael.federacion.model.Equipo;

public interface IEquipoRepository extends JpaRepository<Equipo, Integer>{
    
}
