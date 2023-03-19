package com.frael.federacion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frael.federacion.model.Agenda;

public interface IAgendaRepository extends JpaRepository<Agenda, Integer> {
 
    @Query( value = "EXEC SP_CONSULTA_AGENDAS :VALOR", nativeQuery = true)
    public List<Agenda> findAllFilter(@Param("valor") String valor);
}