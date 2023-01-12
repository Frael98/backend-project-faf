package com.frael.federacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Usuario;
import com.frael.federacion.services.UsuarioService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * Controlador Usuario
 */
@RestController
@RequestMapping("/usuario") // mapear rutar
@CrossOrigin // habilita el cors
public class UsuarioController {

    @Autowired
    private UsuarioService arbitroService;

    /*
     * Guardar Usuario
     * retorna usuario
     */
    @PostMapping(value = "/save")
    public Usuario saveArbitro(@RequestBody Usuario arbitro) {

        try {
            return arbitroService.guardarUsuario(arbitro);
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /*
     * Obtener todos los usuarios
     */
    @GetMapping(value = "/getAll")
    public List<Usuario> getArbitros() {
        try {
            return arbitroService.listarUsuarios();
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /*
     * Actualizar un usuario
     * 
     * @id
     */
    @PutMapping(value = "/update/{id}")
    public Usuario updateArbitro(@PathVariable String id, @RequestBody Usuario newArbitro) {
        try {

            return arbitroService.actualizarUsuario(newArbitro, Integer.parseInt(id));
        } catch (Exception e) {
            System.out.println("Error en actualizacion del Usuario: " + e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    String eliminarArbitro(@PathVariable Integer id) {
        try {
            return arbitroService.eliminarUsuario(id);
        } catch (UserException e) {
            System.out.println("Error en eliminacion del usuario: " + e.getMessage());
        }
        return null;
    }

    @GetMapping(value = "/getArbitro/{id}")
    public Usuario getArbitro(@PathVariable Integer id) {
        return arbitroService.obtenerUsuario(id);
    }

}
