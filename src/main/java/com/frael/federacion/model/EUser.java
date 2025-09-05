package com.frael.federacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * Entidad Usuario
 * 
 */

@Getter
@Setter
@Table(name = "USUARIO")
@MappedSuperclass
public class EUser extends Entidad {

    @Column(name = "nombre", columnDefinition = "")
    protected String nombre;
    @Column(name = "apellido", columnDefinition = "")
    protected String apellido;
    @Column(name = "usuario_nombre", columnDefinition = "")
    protected String usuario;
    @Column(name = "correo", columnDefinition = "")
    protected String correo;
    @Column(name = "contrasenia", columnDefinition = "")
    protected String contrasenia;
    
}
