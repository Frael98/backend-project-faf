package com.frael.federacion.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"USUARIO\"")
public abstract class Usuario {
    
    @Id //Se lo identifica con ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    protected Integer id;

    @Column( name = "NOMBRE")
    protected String nombre;
    @Column(name = "apellidos")
    protected String apellidos;
    @Column(name = "usuario_nombre")
    protected String usuario;
    @Column(name = "correo")
    protected String correo;
    @Column(name = "contrasenia")
    protected String contrasenia;
    @Column(name = "estado")
    protected char estado;
    @Column(name = "createdAt")
    protected Date createdAt;
    @Column(name = "updatedAt")
    protected Date updateAt;


    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
    
}
