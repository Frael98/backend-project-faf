package com.frael.federacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Administrador;
import com.frael.federacion.services.AdministradorService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * REST Controlador Administrador
 * 
 */
@RestController
@CrossOrigin
@RequestMapping("/administrador")
public class AdministradorController {
    
    @Autowired
    private AdministradorService admService;

    @PostMapping(value="/save")
    public Administrador postMethodName(@RequestBody Administrador entity) {
        
        try {
            return admService.guardarAdministrador(entity);
        } catch (UserException e) {
           System.out.println("Error en inserccion de administrador: "+ e.getMessage());
        }
        return null;
    }
    
    @GetMapping(value="/get")
    public List<Administrador> obtenerAll(@RequestParam String param) {
        try {
            return admService.listarAdministrador();
        } catch (UserException e) {
             System.out.println("Error en listar administradores: "+ e.getMessage());
        }
        return null;
    }
    
    @PostMapping(value="/get/{usuario}")
    public Administrador obtenerAdministrador(@PathVariable String usuario, @RequestBody Administrador adm) {
        try {
            return admService.obtenerAdministrador(usuario, adm.getContrasenia());
        } catch (UserException e) {
            System.out.println("Error en obtener administrador: "+ e.getMessage());
        }
        return null;
    }
    
    @PutMapping(value="/update/{id}")
    public Administrador putMethodName(@PathVariable Integer id, @RequestBody Administrador entity) {
        
        try {
            return admService.actualizarAdministrador(entity, id);
        } catch (UserException e) {
            System.out.println("Error en actualizar administrador: "+ e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    Administrador deleteAdministrador(@PathVariable Integer id){
        try {
            return admService.eliminarAdministrador(id);
        } catch (UserException e) {
            System.out.println("Error en eliminar administrador: "+ e.getMessage());
        }
        return null;
    }
}
