package com.frael.federacion.services.Interfaces;

import java.util.List;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Usuario;

public interface IUsuarioService {

    public Usuario guardarAdministrador(Usuario Administrador) throws UserException;

    public List<Usuario> listarAdministrador() throws UserException;

    public Usuario actualizarAdministrador(Usuario neaAdministrador, Integer id) throws UserException;

    public Usuario eliminarAdministrador(Integer id) throws UserException;

    public Usuario obtenerAdministrador(String usuario, String pwd) throws UserException;
}
