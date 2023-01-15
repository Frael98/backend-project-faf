package com.frael.federacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

/*
 * Entidad Usuario
 * 
 */

@Table(name = "USUARIO")
@MappedSuperclass
public class Usuario extends Entidad {

    @Id // Se lo identifica con ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Integer id;

    @Column(name = "nombre")
    protected String nombre;
    @Column(name = "apellido")
    protected String apellido;
    @Column(name = "usuario_nombre")
    protected String usuario;
    @Column(name = "correo")
    protected String correo;
    @Column(name = "contrasenia")
    protected String contrasenia;
    

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellido;
    }

    public void setApellidos(String apellido) {
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
