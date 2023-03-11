package com.frael.federacion.services.Interfaces;

import java.util.List;

import com.frael.federacion.exceptions.ActaException;
import com.frael.federacion.model.ActaPartido;

public interface IActaPartidoService {
    
    public ActaPartido guardarActaPartido(ActaPartido ActaPartido) throws ActaException;

    public List<ActaPartido> listarActaPartido() throws ActaException;

    public ActaPartido actualizarActaPartido(ActaPartido neaActaPartido, Integer id) throws ActaException;

    public ActaPartido eliminarActaPartido(Integer id) throws ActaException;

    public ActaPartido obtenerActaPartido(String usuario, String pwd) throws ActaException;
}
