package com.frael.federacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frael.federacion.model.Agenda;

public interface IAgendaRepository extends JpaRepository<Agenda, Integer> {
    
}
