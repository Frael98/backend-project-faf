package com.frael.federacion.services.Interfaces;

import java.util.List;

import com.frael.federacion.exceptions.ActaException;
import com.frael.federacion.model.ActaPartido;

public interface IActaPartidoService {
    
    public ActaPartido guardarActaPartido(ActaPartido actaPartido) throws ActaException;

    public List<ActaPartido> listarActaPartido(String valor) throws ActaException;

    public ActaPartido actualizarActaPartido(ActaPartido newActaPartido, Integer id) throws ActaException;

    public ActaPartido eliminarActaPartido(Integer id) throws ActaException;

    public ActaPartido obtenerActaPartido(Integer id) throws ActaException;
}
