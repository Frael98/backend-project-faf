package com.frael.federacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frael.federacion.exceptions.EquipoException;
import com.frael.federacion.model.Equipo;
import com.frael.federacion.services.EquipoService;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    /**
     * 
     * @param entity
     * @return Equipo
     * @ready
     */
    @PostMapping(value = "/save")
    public Equipo guardarEquipo(@RequestBody Equipo entity) {

        try {
            return equipoService.guardarEquipo(entity);
        } catch (EquipoException e) {
            System.out.println("Error en inserccion de equipo: " + e.getMessage());
        }
        return null;
    }

    /**
     *
     * @return Lista de equipos
     */
    @GetMapping(value = "/getAll")
    public List<Equipo> obtenerEquipos() {
        try {
            return equipoService.listarEquipo();
        } catch (EquipoException e) {
            System.out.println("Error en listar equipo: " + e.getMessage());
        }
        return null;
    }

    @PutMapping(value = "/update/{id}")
    public Equipo actualizarEquipo(@PathVariable Integer id, @RequestBody Equipo entity) {

        try {
            return equipoService.actualizarEquipo(entity, id);
        } catch (EquipoException e) {
            System.out.println("Error en actualizar equipo: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/getEquipo/{id}")
    public Equipo obtenerEquipo(@PathVariable Integer id) {

        try {
            return equipoService.obtenerEquipo(id);
        } catch (EquipoException e) {
            return null;
        }
    }
}
