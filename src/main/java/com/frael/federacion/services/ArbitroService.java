package com.frael.federacion.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Arbitro;
import com.frael.federacion.repo.IArbitroRepository;

@Service
public class ArbitroService implements IArbitroService {
    
    @Autowired
    private IArbitroRepository arbitroRepository;

    @Override
    public Arbitro guardarArbitro(Arbitro arbitro) throws UserException{
        Arbitro nuevArbitro = arbitroRepository.save(arbitro);
        if(nuevArbitro.equals(null)){
            throw new UserException("Error en guardar Arbitro");
        }
        return nuevArbitro;
    }

    @Override
    public List<Arbitro> listarArbitros() throws UserException {
        if(arbitroRepository.findAll().isEmpty()){
            throw new UserException("no se encontraron datos de Arbitros");
        }
        return arbitroRepository.findAll();
    }

    @Override
    public Arbitro actualizarArbitro(Arbitro newArbitro, Integer id) throws UserException {

        return arbitroRepository.findById(id).map(a -> {
            a.setNombre(newArbitro.getNombre());
            a.setApellidos(newArbitro.getApellidos());
            a.setUsuario(newArbitro.getUsuario());
            a.setCorreo(newArbitro.getCorreo());
            a.setContrasenia(newArbitro.getContrasenia());
            a.setUpdateAt(new Date(System.currentTimeMillis()));
            a.setAltura(newArbitro.getAltura());
            a.setComite(newArbitro.getComite());
            a.setDireccion(newArbitro.getDireccion());
            a.setCategoria(newArbitro.getCategoria());
            a.setFuncion(newArbitro.getFuncion());
            a.setNacionalidad(newArbitro.getNacionalidad());
            a.setPartidos(newArbitro.getPartidos());
            return arbitroRepository.save(a);
        }).orElseThrow(() -> new UserException("Arbitro no Encontrado"));

    }

    @Override
    public String eliminarArbitro(Integer id) throws UserException {
        if (!arbitroRepository.existsById(id)) {
            throw new UserException("El Arbitro no existe");
        }
        arbitroRepository.findById(id).map( a -> {
            a.setEstado('E');
            a.setDeleteAt(new Date(System.currentTimeMillis()));

            return arbitroRepository.save(a);
        }).orElseThrow(()-> new UserException("No se pudo eliminar Arbitro"));

        return "Arbitro ELiminado con id" + id + " con exito";
    }

    @Override
    public Arbitro obtenerArbitro(Integer id) {
        return arbitroRepository.findById(id).get();
    }
}
