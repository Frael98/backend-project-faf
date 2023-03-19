package com.frael.federacion.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frael.federacion.exceptions.AgendaException;
import com.frael.federacion.model.Agenda;
import com.frael.federacion.repo.IAgendaRepository;
import com.frael.federacion.services.Interfaces.IAgendaService;

@Service
public class AgendaService implements IAgendaService {

    @Autowired
    private IAgendaRepository agendaRepository;

    @Override
    public Agenda guardarAgenda(Agenda agenda) throws AgendaException {
        Agenda tmp = agendaRepository.save(agenda);
        if(tmp.equals(null)){
            throw new AgendaException("");
        }
        return tmp;
    }

    @Override
    public List<Agenda> listarAgendas(String valor) throws AgendaException {
        if(agendaRepository.findAllFilter(valor).isEmpty()){
            throw new AgendaException("");
        }
        return agendaRepository.findAllFilter(valor);
    }

    @Override
    public Agenda actualizarAgenda(Agenda agenda, Integer id) throws AgendaException {
        return agendaRepository.findById(id).map( a -> {
            a.setUpdateAt(new Date(System.currentTimeMillis()));
            a.setLugarPartido(agenda.getLugarPartido());
            a.setFechaPartido(agenda.getFechaPartido());
            a.setHoraPartido(agenda.getHoraPartido());

            return agendaRepository.save(a);
        }).orElseThrow( () -> new AgendaException("null"));
    }

    @Override
    public Agenda eliminarAgenda(Integer id) throws AgendaException {
        
        return agendaRepository.findById(id).map( a -> {
            a.setEstado('E');
            a.setDeleteAt(new Date(System.currentTimeMillis()));
            return agendaRepository.save(a);
        }).orElseThrow( () -> new AgendaException(""));
    }
    
}
