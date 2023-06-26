package com.frael.federacion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frael.federacion.exceptions.PartidoException;
import com.frael.federacion.model.Partido;
import com.frael.federacion.repo.IPartidoRepository;
import com.frael.federacion.services.Interfaces.IPartidoService;

@Service
public class PartidoService implements IPartidoService {

    @Autowired
    private static IPartidoRepository partidoRepository;

    @Override
    public Partido guardarPartido(Partido partido) throws PartidoException {
       Partido tmp = partidoRepository.save(partido);
       if(tmp.equals(null)){
        throw new PartidoException("Error en guardar partido");
       }
       return tmp;
    }
    
}
