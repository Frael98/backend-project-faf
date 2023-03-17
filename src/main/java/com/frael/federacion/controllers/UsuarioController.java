package com.frael.federacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Usuario;
import com.frael.federacion.services.UsuarioService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * REST Controlador Administrador
 * 
 */
@RestController
@CrossOrigin
@RequestMapping("/administrador")
public class UsuarioController {
    
    @Autowired
    private UsuarioService admService;
    
    /**
     * 
     * @param entity
     * @return Administador
     * @ready
     */
    @PostMapping(value="/save")
    public Usuario postMethodName(@RequestBody Usuario entity) {
        
        try {
            return admService.guardarAdministrador(entity);
        } catch (UserException e) {
           System.out.println("Error en inserccion de administrador: "+ e.getMessage());
        }
        return null;
    }
    
    /**
     *
     * @return Lista de Administradores
     */
    @GetMapping(value="/getAll")
    public List<Usuario> obtenerAll() {
        try {
            return admService.listarAdministrador();
        } catch (UserException e) {
             System.out.println("Error en listar usuarios: "+ e.getMessage());
        }
        return null;
    }
    
    /**
     * 
     * @param usuario
     * @param adm
     * @return Response Administrador
     */
    @PostMapping(value="/get/{usuario}")
    public ResponseEntity<Usuario> obtenerAdministrador(@PathVariable String usuario, @RequestBody Usuario adm) {        
        try {
            adm = admService.obtenerAdministrador(usuario, adm.getContrasenia());
            return new ResponseEntity<Usuario>(adm, HttpStatus.OK);
        } catch (UserException e) {
            adm = null;
            System.out.println("Error en obtener administrador: "+ e.getMessage());
            return new ResponseEntity<Usuario>(adm, HttpStatus.OK);
        }
    }
    
    @PutMapping(value="/update/{id}")
    public Usuario putMethodName(@PathVariable Integer id, @RequestBody Usuario entity) {
        
        try {
            return admService.actualizarAdministrador(entity, id);
        } catch (UserException e) {
            System.out.println("Error en actualizar administrador: "+ e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    Usuario deleteAdministrador(@PathVariable Integer id){
        try {
            return admService.eliminarAdministrador(id);
        } catch (UserException e) {
            System.out.println("Error en eliminar administrador: "+ e.getMessage());
        }
        return null;
    }

}
