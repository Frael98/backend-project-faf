package com.frael.federacion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frael.federacion.model.ActaPartido;

public interface IActaPartidoRepository extends JpaRepository<ActaPartido, Integer>{
    
    @Query( value = "EXEC SP_CONSULTA_ACTAPARTIDOS :VALOR", nativeQuery = true)
    public List<ActaPartido> findAllFilter(@Param("VALOR") String valor);
}
