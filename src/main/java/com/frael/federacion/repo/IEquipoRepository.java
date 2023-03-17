package com.frael.federacion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.frael.federacion.model.Equipo;

public interface IEquipoRepository extends JpaRepository<Equipo, Integer>{
    
    @Query( value = "SELECT * FROM ARBITRO A WHERE A.ESTADO <> 'E'", nativeQuery = true)
    public List<Equipo> findOnlyActive();
    
}
