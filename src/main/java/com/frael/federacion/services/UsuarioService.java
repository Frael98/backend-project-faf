package com.frael.federacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.Usuario;
import com.frael.federacion.repo.UsuarioRepository;

/*
 * Servicio Usuario
 * Conecta con el repositorio
 */
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public Usuario guardarUsuario(Usuario arbitro) throws UserException{

        Usuario nuevUsuario = userRepository.save(arbitro);
        if(nuevUsuario.equals(null)){
            throw new UserException("Error en guardar usuario");
        }
        return nuevUsuario;
    }

    @Override
    public List<Usuario> listarUsuarios() throws UserException {
        if(userRepository.findAll().isEmpty()){
            throw new UserException("no se encontraron datos de usuarios");
        }
        return userRepository.findAll();
    }

    @Override
    public Usuario actualizarUsuario(Usuario newArbitro, Integer id) throws UserException {

        return userRepository.findById(id).map(a -> {
            a.setNombre(newArbitro.getNombre());
            return userRepository.save(a);
        }).orElseThrow(() -> new UserException("Usuario no Encontrado"));

    }

    @Override
    public String eliminarUsuario(Integer id) throws UserException {
        if (!userRepository.existsById(id)) {
            throw new UserException("El usuario no existe");
        }
        userRepository.deleteById(id);
        return "Arbitro ELiminado con id" + id + " con exito";
    }

    @Override
    public Usuario obtenerUsuario(Integer id) {
        return userRepository.findById(id).get();
    }

}
