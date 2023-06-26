package com.frael.federacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frael.federacion.exceptions.AgendaException;
import com.frael.federacion.exceptions.PartidoException;
import com.frael.federacion.model.Agenda;
import com.frael.federacion.model.Partido;
import com.frael.federacion.services.AgendaService;
import com.frael.federacion.services.PartidoService;

@RestController
@CrossOrigin
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private PartidoService partidoService;

    @PostMapping(value = "/save")
    public Agenda guardarAgenda(@RequestBody Agenda agenda, @RequestBody Partido partido) {
        Partido o = null;
        Agenda tmp = null;
        try {
            o = partidoService.guardarPartido(partido);
            tmp = agendaService.guardarAgenda(agenda);
        } catch (PartidoException | AgendaException a) {
            System.out.println(a.getMessage());
        }
        return tmp;
    }
}
