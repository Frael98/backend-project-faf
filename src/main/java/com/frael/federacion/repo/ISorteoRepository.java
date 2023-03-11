package com.frael.federacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frael.federacion.model.Sorteo;

public interface ISorteoRepository extends JpaRepository<Sorteo, Integer> {
    
}
