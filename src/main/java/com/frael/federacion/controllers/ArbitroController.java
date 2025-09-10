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

import jakarta.validation.Valid;

/**
 * @author Flavio Campos
 * @since 1.0.0
 */
@RestController
@CrossOrigin
@RequestMapping("/arbitro")
public class ArbitroController {

    @Autowired
    private ArbitroService arbitroService;

    /**
     * Guardar Arbitro
     * 
     * @param Arbitro arbitro a ser guardado
     * @ready
     */
    @PostMapping(value = "/save") // consumes = "application/json", produces = "application/json"
    public ResponseEntity<Arbitro> saveArbitro(@Valid @RequestBody Arbitro arbitro) throws UserException {
        Arbitro nuevoArbitro = arbitroService.guardarArbitro(arbitro);
        return new ResponseEntity<>(nuevoArbitro, HttpStatus.CREATED);
    }

    /**
     * Obtener todos los Arbitros
     * 
     * @return List<Arbitros> lista de arbitros
     */
    @GetMapping(value = "/getArbitros")
    public ResponseEntity<List<Arbitro>> getArbitros() throws UserException {
        List<Arbitro> lista = arbitroService.listarArbitros();
        return new ResponseEntity<List<Arbitro>>(lista, HttpStatus.OK);
    }

    /**
     * Actualizar un Arbitro
     * 
     * @param String id del arbitro
     * @param Arbitro nuevo arbitro
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Arbitro> updateArbitro(@PathVariable String id, @Valid @RequestBody Arbitro newArbitro)
            throws UserException {

        Arbitro arbitro = arbitroService.actualizarArbitro(newArbitro, Integer.parseInt(id));
        return new ResponseEntity<>(arbitro, HttpStatus.NO_CONTENT);
    }

    /**
     * Ruta eliminar
     * 
     * @param id
     * @return mensaje
     */
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> eliminarArbitro(@PathVariable Integer id) throws UserException {

        String message = arbitroService.eliminarArbitro(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * Obtener arbitro inicio sesion
     * 
     * @apiNote No se pone @Valid para que no exiga validacion de los otros campos
     * @param Arbitro arbitro
     * @return arbitro
     */
    @PostMapping(value = "/loginArbitro")
    public ResponseEntity<Arbitro> getArbitroUsuario(@RequestBody Arbitro user) throws UserException {

        Arbitro arbitro = arbitroService.obtenerArbitroSesion(user);
        return new ResponseEntity<Arbitro>(arbitro, HttpStatus.OK);
    }

    /**
     * Obtener un arbitro por id
     * 
     * @param Integer id del arbitro
     * @return ResponseEntity<Arbitro>
     */
    @GetMapping("/getArbitro/{id}")
    public ResponseEntity<Arbitro> getArbitro(@PathVariable Integer id) throws UserException {
        Arbitro arbitro = arbitroService.obtenerArbitro(id);
        return new ResponseEntity<>(arbitro, HttpStatus.FOUND);
    }

}
