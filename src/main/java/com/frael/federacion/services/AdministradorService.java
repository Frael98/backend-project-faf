package com.frael.federacion.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Administrador;
import com.frael.federacion.repo.IAdministradorRepository;

@Service
public class AdministradorService implements IAdministradorService {

    @Autowired
    private IAdministradorRepository admRepository;

    /**
     * @param administrador
     * @return administrador
     */
    @Override
    public Administrador guardarAdministrador(Administrador administrador) throws UserException {

        Administrador tmp = admRepository.save(administrador);
        if (tmp.equals(null)) {
            throw new UserException("Error en guardar datos");
        }
        return admRepository.save(administrador);
    }

    /**
     * @return Listado<Administrador>
     */
    @Override
    public List<Administrador> listarAdministrador() throws UserException {

        if (admRepository.findAll().isEmpty()) {
            throw new UserException("Error en listar administradores");
        }
        return admRepository.findAll();
    }

    /**
     * Actualiza el administrador por id
     * 
     * @param newAdministrador
     * @param id
     * 
     * @return administrador
     */
    @Override
    public Administrador actualizarAdministrador(Administrador newAdministrador, Integer id) throws UserException {

        return admRepository.findById(id).map(e -> {
            e.setApellidos(newAdministrador.getApellidos());
            e.setCorreo(newAdministrador.getCorreo());
            e.setUsuario(newAdministrador.getUsuario());
            e.setUpdateAt(new Date(System.currentTimeMillis()));
            e.setContrasenia(newAdministrador.getContrasenia());
            return admRepository.save(e);
        }).orElseThrow(() -> new UserException("No fue posible encontrar o no existe con id: " + id));
    }

    /**
     * @param id
     * @return administrador
     * @throws UserException
    */
    @Override
    public Administrador eliminarAdministrador(Integer id) throws UserException {

        if (!admRepository.findById(id).isEmpty()) {

            return admRepository.findById(id).map((e) -> {
                e.setDeleteAt(new Date(System.currentTimeMillis()));
                e.setEstado('E');

                return admRepository.save(e);
            }).orElseThrow(() -> new UserException("Invalido administrador con id: " + id));
        }
        return null;
    }

    /**
     * @param usuario
     * @param contrasenia
     * @return administrador
     * 
     * @throws UserException
     */
    @Override
    public Administrador obtenerAdministrador(String usuario, String contrasenia) throws UserException {

        return (admRepository.findByUsuario(usuario).map(e -> {
            if (e.getUsuario().equals(usuario) && e.getContrasenia().equals(contrasenia)) {
                return e;
            }
            return null;
        })).orElseThrow(() -> new UserException("Usuario no se encuentra en bd: " + usuario));
    }

}
