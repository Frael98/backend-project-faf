package com.frael.federacion.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frael.federacion.exceptions.EquipoException;
import com.frael.federacion.model.Equipo;
import com.frael.federacion.repo.IEquipoRepository;
import com.frael.federacion.services.Interfaces.IEquipoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EquipoService implements IEquipoService{

    @Autowired
    private IEquipoRepository equipoRepository;

    @Override
    public Equipo guardarEquipo(Equipo equipo) throws EquipoException {
        Equipo nuevoEquipo = equipoRepository.save(equipo);
        log.info("Guardando equipo {}", equipo.getNombre());
        if(nuevoEquipo.getNombre() == null){
            throw new EquipoException("Nombre de Equipo no puede ser vacio");
        }
        return nuevoEquipo;
    }

    @Override
    public List<Equipo> listarEquipos() throws EquipoException {
        if(equipoRepository.findOnlyActive().isEmpty()){
            throw new EquipoException("No existen registros activos o inactivos");
        }

        return equipoRepository.findOnlyActive();
    }

    @Override
    public Equipo actualizarEquipo(Equipo equipo, Integer id) throws EquipoException {
        
        return equipoRepository.findById(id).map(e -> {
            e.setDirector(equipo.getDirector());
            e.setNombre(equipo.getNombre());
            e.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return equipoRepository.save(e);
        }).orElseThrow( () -> new EquipoException("No fue posible encontrar equipo o no existe, id: " + id));
    }

    @Override
    public String eliminarEquipo(Integer id) throws EquipoException {
        if(!equipoRepository.existsById(id)){
            throw new EquipoException("No existe equipo con id: " + id);
        }
        equipoRepository.findById(id).map(e -> {
            e.setEstado('E');
            e.setDeletedAt(new Timestamp(System.currentTimeMillis()));

            return equipoRepository.save(e);
        });
        return "Equipo eliminado con id: " + id + " con exito";
    }

    @Override
    public Equipo obtenerEquipo(Integer id) throws EquipoException {
        return equipoRepository.findById(id).map(e -> {
            return e;
        }).orElseThrow( () -> new EquipoException("Equipo no se encuentra en bd: " + id));
    }

    @Override
    public List<Equipo> listarEquipoFiltro(String valor) throws EquipoException {
        if(equipoRepository.findAllFilter(valor).isEmpty()){
            throw new EquipoException("No existen registros de equipos con este filtro");
        }

        return equipoRepository.findAllFilter(valor);
    }

}

