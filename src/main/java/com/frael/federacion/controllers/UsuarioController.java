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

@RestController
@RequestMapping("/arbitro") // mapear rutar
@CrossOrigin // habilita el cors
public class UsuarioController {

    @Autowired
    private UsuarioService arbitroService;

    @PostMapping(value = "/save")
    public Usuario saveArbitro(@RequestBody Usuario arbitro) {

        return arbitroService.guardarUsuario(arbitro);
    }

    @GetMapping(value = "/getAll")
    public List<Usuario> getArbitros() {
        return arbitroService.listarUsuarios();
    }

    @PutMapping(value = "/update/{id}")
    public Usuario updateArbitro(@PathVariable String id, @RequestBody Usuario newArbitro) {
        try {

            return arbitroService.actualizarUsuario(newArbitro, Integer.parseInt(id));
        } catch (Exception e) {
           System.out.println("Error en actualizacion del Usuario");
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    String eliminarArbitro(@PathVariable Integer id){
        try {
            return arbitroService.eliminarUsuario(id);
        } catch (UserException e) {
           System.out.println("Error en eliminacion del usuario");
        }
        return null;
    }

    @GetMapping(value = "/getArbitro/{id}")
    public Usuario getArbitro(@PathVariable Integer id) {
        return arbitroService.obtenerUsuario(id);
    }

}
