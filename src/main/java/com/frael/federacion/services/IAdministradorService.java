package com.frael.federacion.services;

import java.util.List;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Administrador;

public interface IAdministradorService {

    public Administrador guardarAdministrador(Administrador Administrador) throws UserException;

    public List<Administrador> listarAdministrador() throws UserException;

    public Administrador actualizarAdministrador(Administrador neaAdministrador, Integer id) throws UserException;

    public Administrador eliminarAdministrador(Integer id) throws UserException;

    public Administrador obtenerAdministrador(String usuario, String pwd) throws UserException;
}
