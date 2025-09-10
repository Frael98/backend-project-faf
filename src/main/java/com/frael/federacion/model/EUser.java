package com.frael.federacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "El nombre debe ser especificado")
    @Column(name = "nombre", columnDefinition = "")
    protected String nombre;

    @NotNull(message = "El apellido debe ser especificado")
    @Column(name = "apellido", columnDefinition = "")
    protected String apellido;

    @NotNull(message = "El usuario debe ser especificado")
    @Column(name = "usuario_nombre", columnDefinition = "")
    protected String usuario;

    @NotNull(message = "El correo es obligatorio")
    @Column(name = "correo", columnDefinition = "")
    protected String correo;

    @NotNull(message = "La contraseña es requerida")
    @Column(name = "contrasenia", columnDefinition = "")
    protected String contrasenia;
    
}
