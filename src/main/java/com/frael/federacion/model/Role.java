package com.frael.federacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role extends Entidad {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    protected Integer id_rol;

    @Column( name = "nombre_rol")
    protected String nombreRol;

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Integer getId() {
        return id_rol;
    }

    
}
