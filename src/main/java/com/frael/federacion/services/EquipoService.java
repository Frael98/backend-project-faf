package com.frael.federacion.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frael.federacion.exceptions.EquipoException;
import com.frael.federacion.model.Equipo;
import com.frael.federacion.repo.IEquipoRepository;
import com.frael.federacion.services.Interfaces.IEquipoService;

@Service
public class EquipoService implements IEquipoService{

    @Autowired
    private IEquipoRepository equipoRepository;

    @Override
    public Equipo guardarEquipo(Equipo equipo) throws EquipoException {
        Equipo nuevoEquipo = equipoRepository.save(equipo);
        if(nuevoEquipo.equals(null)){
            throw new EquipoException("Error al guardar equipo");
        }
        return nuevoEquipo;
    }

    @Override
    public List<Equipo> listarEquipo() throws EquipoException {
        if(equipoRepository.findOnlyActive().isEmpty()){
            throw new EquipoException("Error en listar equipos");
        }

        return equipoRepository.findOnlyActive();
    }

    @Override
    public Equipo actualizarEquipo(Equipo equipo, Integer id) throws EquipoException {
        
        return equipoRepository.findById(id).map(e -> {
            e.setDirector(equipo.getDirector());
            e.setNombre(equipo.getNombre());
            e.setUpdateAt(new Date(System.currentTimeMillis()));
            return equipoRepository.save(e);
        }).orElseThrow( () -> new EquipoException("No fue posible encontrar equipo o no existe con id: " + id));
    }

    @Override
    public String eliminarEquipo(Integer id) throws EquipoException {
        if(!equipoRepository.existsById(id)){
            throw new EquipoException("No existe equipo con id: " + id);
        }
        equipoRepository.findById(id).map(e -> {
            e.setEstado('E');
            e.setDeleteAt(new Date(System.currentTimeMillis()));

            return equipoRepository.save(e);
        });
        return "Equipo eliminado con id: " + id + " con exito";
    }

    @Override
    public Equipo obtenerEquipo(Integer id) throws EquipoException {
    
        return equipoRepository.findById(id).map(e -> {
            return e;
        }).orElseThrow( () -> new EquipoException("equipo no se encuentra en bd: " + id));
    }

    @Override
    public List<Equipo> listarEquipoFiltro(String valor) throws EquipoException {
        if(equipoRepository.findAllFilter(valor).isEmpty()){
            throw new EquipoException("Error en listar equipos");
        }

        return equipoRepository.findAllFilter(valor);
    }

}

