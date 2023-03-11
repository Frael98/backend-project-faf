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

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Arbitro;
import com.frael.federacion.services.ArbitroService;

@RestController
@CrossOrigin
@RequestMapping("/arbitro")
public class ArbitroController {

    @Autowired
    private ArbitroService arbitroService;

    /**
     * Guardar Arbitro
     * retorna Arbitro
     * @ready
     */
    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public Arbitro saveArbitro(@RequestBody Arbitro arbitro) {
        try {
            return arbitroService.guardarArbitro(arbitro);
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    /**
     * Obtener todos los Arbitros
     */
    @GetMapping(value = "/getArbitros")
    public ResponseEntity<List<Arbitro>> getArbitros() {
        List<Arbitro> lista;
        try{
            lista = arbitroService.listarArbitros();
            return new ResponseEntity<List<Arbitro>>(lista, HttpStatus.OK);
        } catch (UserException e) {
            lista = null;
            System.out.println(e.getMessage());
            return new ResponseEntity<List<Arbitro>>(lista, HttpStatus.OK);
        }
    }

    /**
     * Actualizar un Arbitro
     * 
     * @id
     */
    @PutMapping(value = "/update/{id}")
    public Arbitro updateArbitro(@PathVariable String id, @RequestBody Arbitro newArbitro) {
        try {
            return arbitroService.actualizarArbitro(newArbitro, Integer.parseInt(id));
        } catch (Exception e) {
            System.out.println("Error en actualizacion del Arbitro: " + e.getMessage());
        }
        return null;
    }

    /**
     * Ruta eliminar
     * @param id
     * @return mensaje
     */
    @DeleteMapping("/delete/{id}")
    String eliminarArbitro(@PathVariable Integer id) {
        try {
            return arbitroService.eliminarArbitro(id);
        } catch (UserException e) {
            System.out.println("Error en eliminacion del Arbitro: " + e.getMessage());
        }
        return null;
    }

    /**
     * 
     * @param id
     * @return arbitro
     */
    @PostMapping(value = "/getArbitro")
    public ResponseEntity<Arbitro> getArbitroUsuario( @RequestBody Arbitro user) {
        Arbitro arbitro;
        try {
            arbitro = arbitroService.obtenerArbitroSesion(user);
            return new ResponseEntity<Arbitro>(arbitro, HttpStatus.OK);
        } catch (UserException e) {
            arbitro = null;
            System.out.println(e.getMessage());
            return new ResponseEntity<Arbitro>(arbitro, HttpStatus.OK);
        }
    }
    
}
