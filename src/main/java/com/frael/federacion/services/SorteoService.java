package com.frael.federacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frael.federacion.exceptions.SorteoException;
import com.frael.federacion.model.Sorteo;
import com.frael.federacion.repo.ISorteoRepository;
import com.frael.federacion.services.Interfaces.ISorteService;

@Service
public class SorteoService implements ISorteService{

    @Autowired
    private ISorteoRepository sorteoRepository;

    @Override
    public Sorteo generarSorteo(Sorteo sorteo) throws SorteoException {
        Sorteo tmp = sorteoRepository.save(sorteo);

        if(tmp.equals(null)){
            throw new SorteoException("");
        }
        return tmp;
    }

    @Override
    public List<Sorteo> listarSorteos(String valor) throws SorteoException {
        if(sorteoRepository.findAllFilter(valor).isEmpty()){
            throw new SorteoException("valor");
        }
        return sorteoRepository.findAllFilter(valor);
    }
    
}
