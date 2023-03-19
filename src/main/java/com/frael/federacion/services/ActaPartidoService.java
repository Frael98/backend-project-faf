package com.frael.federacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frael.federacion.exceptions.ActaException;
import com.frael.federacion.model.ActaPartido;
import com.frael.federacion.repo.IActaPartidoRepository;
import com.frael.federacion.services.Interfaces.IActaPartidoService;

@Service
public class ActaPartidoService implements IActaPartidoService {

    @Autowired
    public IActaPartidoRepository actaPartidoRepository;

    @Override
    public ActaPartido guardarActaPartido(ActaPartido actaPartido) throws ActaException {
        ActaPartido tmp = actaPartidoRepository.save(actaPartido);
        if (tmp.equals(null)) {
            throw new ActaException("null");
        }
        return tmp;
    }

    @Override
    public List<ActaPartido> listarActaPartido(String valor) throws ActaException {
        if (actaPartidoRepository.findAllFilter(valor).isEmpty()) {
            throw new ActaException("null");
        }

        return actaPartidoRepository.findAllFilter(valor);
    }

    @Override
    public ActaPartido actualizarActaPartido(ActaPartido newActaPartido, Integer id) throws ActaException {

        return actaPartidoRepository.findById(id).map(a -> {

            return actaPartidoRepository.save(a);
        }).orElseThrow(() -> new ActaException("null"));
    }

    @Override
    public ActaPartido eliminarActaPartido(Integer id) throws ActaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarActaPartido'");
    }

    @Override
    public ActaPartido obtenerActaPartido(Integer id) throws ActaException {

        if (actaPartidoRepository.findById(id).isEmpty()) {
            throw new ActaException("null");
        }
        return actaPartidoRepository.findById(id).get();
    }

}
