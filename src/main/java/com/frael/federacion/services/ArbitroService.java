package com.frael.federacion.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Arbitro;
import com.frael.federacion.repo.IArbitroRepository;
import com.frael.federacion.services.Interfaces.IArbitroService;

@Service
public class ArbitroService implements IArbitroService {

    @Autowired
    private IArbitroRepository arbitroRepository;

    @Override
    public Arbitro guardarArbitro(Arbitro arbitro) throws UserException {
        Arbitro nuevArbitro = arbitroRepository.save(arbitro);
        if (nuevArbitro.equals(null)) {
            throw new UserException("Error en guardar Arbitro");
        }
        return nuevArbitro;
    }

    @Override
    public List<Arbitro> listarArbitros() throws UserException {
        if (arbitroRepository.findOnlyActive().isEmpty()) {
            throw new UserException("no se encontraron datos de Arbitros");
        }
        return arbitroRepository.findOnlyActive();
    }

    @Override
    public Arbitro actualizarArbitro(Arbitro newArbitro, Integer id) throws UserException {

        return arbitroRepository.findById(id).map(a -> {
            a.setNombre(newArbitro.getNombre());
            a.setApellido(newArbitro.getApellido());
            a.setUsuario(newArbitro.getUsuario());
            a.setCorreo(newArbitro.getCorreo());
            a.setContrasenia(newArbitro.getContrasenia());
            a.setUpdateAt(new Date(System.currentTimeMillis()));
            a.setDireccion(newArbitro.getDireccion());
            a.setCategoria(newArbitro.getCategoria());
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
        arbitroRepository.findById(id).map(a -> {
            a.setEstado('E');
            a.setDeleteAt(new Date(System.currentTimeMillis()));

            return arbitroRepository.save(a);
        }).orElseThrow(() -> new UserException("No se pudo eliminar Arbitro"));

        return "Arbitro ELiminado con id" + id + " con exito";
    }

    @Override
    public Arbitro obtenerArbitro(Integer id) throws UserException {
        
        if(!arbitroRepository.findById(id).isPresent()){
            throw new UserException("Arbitro no encontrado");
        }

        return arbitroRepository.findById(id).get();
    }

    /**
     * Busqueda para login
     * 
     * @param user
     * @return Arbitro
     * @throws UserException
     */
    public Arbitro obtenerArbitroSesion(Arbitro user) throws UserException {
        
        return arbitroRepository.findByUsuario(user.getUsuario()).map( 
            e -> {
            if (e.getContrasenia().equals(user.getContrasenia())
                    && e.getUsuario().equals(user.getUsuario())) {
                return e;
            }
            return null;
        }).orElseThrow(() -> new UserException("Arbitro no se encontro"));
    }
}
