package com.frael.federacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin
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
    @GetMapping(value = "/getEquipos")
    public ResponseEntity<List<Equipo>> obtenerEquipos() {
        try {
            return new ResponseEntity<List<Equipo>>(equipoService.listarEquipos(), HttpStatus.OK);
        } catch (EquipoException e) {
            System.out.println("Error en listar equipo: " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
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

    /**
     * Ruta eliminar
     * 
     * @param id
     * @return mensaje
     */
    @DeleteMapping("/delete/{id}")
    String eliminarArbitro(@PathVariable Integer id) {
        try {
            return equipoService.eliminarEquipo(id);
        } catch (EquipoException e) {
            System.out.println("Error en eliminacion del equipo: " + e.getMessage());
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

    @GetMapping(value = "/getEquipos/{valor}")
    public ResponseEntity<List<Equipo>> obtenerEquiposFiltro(@PathVariable String valor) {
        List<Equipo> lista;
        try {
            lista = equipoService.listarEquipoFiltro(valor);
            return new ResponseEntity<List<Equipo>>(lista, HttpStatus.OK);
        } catch (EquipoException e) {
            System.out.println("Error en listar equipos filtro: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
