package com.frael.federacion.services;

import java.util.List;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Arbitro;

public interface IArbitroService {
    
    public Arbitro guardarUsuario(Arbitro arbitro) throws UserException;

    public List<Arbitro> listarUsuarios() throws UserException;

    public Arbitro actualizarUsuario(Arbitro neaArbitro, Integer id) throws UserException;

    public String eliminarUsuario(Integer id) throws UserException;

    public Arbitro obtenerUsuario(Integer id);
}
