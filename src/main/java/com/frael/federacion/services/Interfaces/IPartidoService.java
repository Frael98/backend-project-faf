package com.frael.federacion.services.Interfaces;

import com.frael.federacion.exceptions.PartidoException;
import com.frael.federacion.model.Partido;

public interface IPartidoService {
    
    public Partido guardarPartido(Partido partido) throws PartidoException;
}
