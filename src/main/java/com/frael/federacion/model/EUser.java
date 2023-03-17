package com.frael.federacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

/*
 * Entidad Usuario
 * 
 */

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
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
}
