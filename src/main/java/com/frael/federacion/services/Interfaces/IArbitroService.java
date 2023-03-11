package com.frael.federacion.services.Interfaces;

import java.util.List;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Arbitro;

public interface IArbitroService {
    
    public Arbitro guardarArbitro(Arbitro arbitro) throws UserException;

    public List<Arbitro> listarArbitros() throws UserException;

    public Arbitro actualizarArbitro(Arbitro neaArbitro, Integer id) throws UserException;

    public String eliminarArbitro(Integer id) throws UserException;

    public Arbitro obtenerArbitro(Integer id);
}
