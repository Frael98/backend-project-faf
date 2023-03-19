package com.frael.federacion.services.Interfaces;

import java.util.List;

import com.frael.federacion.exceptions.AgendaException;
import com.frael.federacion.model.Agenda;

public interface IAgendaService {
    
    /**
     * @param agenda
     * @return Agenda
     * @throws AgendaException
     */
    public Agenda guardarAgenda(Agenda agenda) throws AgendaException;

    /**
     * @return List<Agenda>
     * @throws AgendaException
     */
    public List<Agenda> listarAgendas(String valor) throws AgendaException;

    /**
     * @param agenda
     * @param id
     * @return
     * @throws AgendaException
     */
    public Agenda actualizarAgenda(Agenda agenda, Integer id) throws AgendaException;

    /**
     * @param id
     * @return Agenda
     * @throws AgendaException
     */
    public Agenda eliminarAgenda(Integer id) throws AgendaException;
}
