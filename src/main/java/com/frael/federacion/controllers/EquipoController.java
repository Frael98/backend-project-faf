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

import jakarta.validation.Valid;

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
    public ResponseEntity<?> guardarEquipo(@Valid @RequestBody Equipo entity) { // @Valid trabaja con @NotNull
        try {
            Equipo saveEquipo = equipoService.guardarEquipo(entity);
            return new ResponseEntity<Equipo>(saveEquipo, HttpStatus.CREATED);
        } catch (EquipoException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    /**
     *
     * @return Lista de equipos
     */
    @GetMapping(value = "/getEquipos")
    public ResponseEntity<?> obtenerEquipos() {
        List<Equipo> lista;
        try {
            lista = equipoService.listarEquipos();
            return new ResponseEntity<List<Equipo>>(lista, HttpStatus.OK);
        } catch (EquipoException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> actualizarEquipo(@PathVariable Integer id, @Valid @RequestBody Equipo entity) {
        try {
            Equipo nuevoEquipo = equipoService.actualizarEquipo(entity, id);
            return new ResponseEntity<Equipo>(nuevoEquipo, HttpStatus.OK);
        } catch (EquipoException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    /**
     * Ruta eliminar
     * 
     * @param id
     * @return mensaje
     */
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> eliminarArbitro(@PathVariable Integer id) {
        try {
            String message = equipoService.eliminarEquipo(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (EquipoException e) {
            // System.out.println("Error en eliminacion del equipo: " + e.getMessage());
            return ResponseEntity.status(304).body(e.getMessage());
        }
    }

    /**
     * Obtener un equipo por id
     * 
     * @param id
     * @return Equipo
     */
    @GetMapping("/getEquipo/{id}")
    public ResponseEntity<?> obtenerEquipo(@PathVariable Integer id) {
        try {
            Equipo equipoObtenido = equipoService.obtenerEquipo(id);
            return new ResponseEntity<>(equipoObtenido, HttpStatus.ACCEPTED);
        } catch (EquipoException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping(value = "/getEquipos/{valor}")
    public ResponseEntity<?> obtenerEquiposFiltro(@PathVariable String valor) {
        List<Equipo> lista;
        try {
            lista = equipoService.listarEquipoFiltro(valor);
            return new ResponseEntity<List<Equipo>>(lista, HttpStatus.OK);
        } catch (EquipoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
