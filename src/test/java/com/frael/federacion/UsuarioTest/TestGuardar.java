package com.frael.federacion.UsuarioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.frael.federacion.model.Usuario;
import com.frael.federacion.repo.IUsuarioRepository;



@SpringBootTest
public class TestGuardar {
    
    @Autowired
    IUsuarioRepository user;

    @Test
    public void guardarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("German");
        usuario.setApellido("rodriguez");
        usuario.setContrasenia("dasd");
        usuario.setCorreo("dasdfddsf");
        usuario.setUsuario("fdsfffdsfsdfsdfsdf");
        
        user.save(usuario);

        assertEquals("rodriguez", usuario.getApellido());
    }
}
