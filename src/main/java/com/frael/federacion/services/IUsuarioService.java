package com.frael.federacion.services;

import java.util.List;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Usuario;

public interface IUsuarioService {
    
    public Usuario guardarUsuario(Usuario arbitro);

    public List<Usuario> listarUsuarios();

    public Usuario actualizarUsuario(Usuario neaArbitro, Integer id) throws UserException;

    public String eliminarUsuario(Integer id) throws UserException;

    public Usuario obtenerUsuario(Integer id);
}
