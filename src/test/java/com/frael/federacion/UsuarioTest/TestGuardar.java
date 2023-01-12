package com.frael.federacion.UsuarioTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.frael.federacion.model.Usuario;
import com.frael.federacion.repo.UsuarioRepository;

@DataJpaTest
public class TestGuardar {
    
    @Autowired
    UsuarioRepository user;

    @Test
    public Usuario guardarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("German");
        usuario.setApellidos("faadas");
        usuario.setContrasenia("dasd");
        usuario.setCorreo("dasdfddsf");
        usuario.setUsuario("fdsfffdsfsdfsdfsdf");
        return user.save(usuario);
    }
}
