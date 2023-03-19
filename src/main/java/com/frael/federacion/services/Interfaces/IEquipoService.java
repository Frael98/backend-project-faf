package com.frael.federacion.services.Interfaces;

import java.util.List;

import com.frael.federacion.exceptions.EquipoException;
import com.frael.federacion.model.Equipo;

public interface IEquipoService {
    
    /**
     * @param equipo
     * @return
     * @throws EquipoException
     */
    public Equipo guardarEquipo(Equipo equipo) throws EquipoException;

    public List<Equipo> listarEquipo() throws EquipoException;

    public Equipo actualizarEquipo(Equipo equipo, Integer id) throws EquipoException;

    public String eliminarEquipo(Integer id) throws EquipoException;

    public Equipo obtenerEquipo(Integer id) throws EquipoException;

    public List<Equipo> listarEquipoFiltro(String valor) throws EquipoException;
    
}
