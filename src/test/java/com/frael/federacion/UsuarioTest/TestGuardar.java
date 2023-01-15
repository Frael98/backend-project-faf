package com.frael.federacion.UsuarioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.frael.federacion.model.Administrador;
import com.frael.federacion.repo.IAdministradorRepository;



@SpringBootTest
public class TestGuardar {
    
    @Autowired
    IAdministradorRepository user;

    @Test
    public void guardarUsuario(){
        Administrador usuario = new Administrador();
        usuario.setNombre("German");
        usuario.setApellidos("rodriguez");
        usuario.setContrasenia("dasd");
        usuario.setCorreo("dasdfddsf");
        usuario.setUsuario("fdsfffdsfsdfsdfsdf");
        
        user.save(usuario);

        assertEquals("rodriguez", usuario.getApellidos());
    }
}
