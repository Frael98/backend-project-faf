package com.frael.federacion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frael.federacion.model.Sorteo;

public interface ISorteoRepository extends JpaRepository<Sorteo, Integer> {
    
    @Query( value = "EXEC SP_CONSULTA_SORTEO :VALOR", nativeQuery = true)
    public List<Sorteo> findAllFilter(@Param("valor") String valor);
}
