package com.frael.federacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Administrador extends Usuario{
    
    @Id // Se lo identifica con ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Integer id;

    public Integer getId() {
        return id;
    }

    
}
