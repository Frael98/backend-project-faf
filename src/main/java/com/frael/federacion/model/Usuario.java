package com.frael.federacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario extends EUser{
    
    @Id // Se lo identifica con ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Integer id;

    public Integer getId() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "rol_id")
    protected Role rol;

    
}
