package com.frael.federacion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frael.federacion.model.Equipo;

public interface IEquipoRepository extends JpaRepository<Equipo, Integer> {

    @Query(value = "SELECT * FROM EQUIPO E WHERE E.ESTADO <> 'E'", nativeQuery = true)
    public List<Equipo> findOnlyActive();

    @Query(value = "EXEC SP_CONSULTA_EQUIPOS :valor ", nativeQuery = true)
    public List<Equipo> findAllFilter(@Param("valor") String valor);

}
