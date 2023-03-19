package com.frael.federacion.services.Interfaces;

import java.util.List;

import com.frael.federacion.exceptions.SorteoException;
import com.frael.federacion.model.Sorteo;

public interface ISorteService {
    
    public Sorteo generarSorteo(Sorteo sorteo) throws SorteoException;

    public List<Sorteo> listarSorteos(String valor) throws SorteoException;
}
