package com.frael.federacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frael.federacion.model.Partido;

public interface IPartidoRepository extends JpaRepository<Partido, Integer> {
    
}
