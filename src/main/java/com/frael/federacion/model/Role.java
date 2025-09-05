package com.frael.federacion.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Role extends Entidad {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    protected Integer id_rol;

    @Column( name = "nombre_rol")
    protected String nombreRol;

    // Relacion con Usuario
    @OneToOne( mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Usuario administrador;
}
