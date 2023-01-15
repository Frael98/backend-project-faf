package com.frael.federacion.model;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ActaPartido extends Entidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Integer id;
    protected Integer idPartido;
    protected Date fechaEmision;
    
    protected Integer cantTarjetasRojas;
    protected Integer cantTarjetasAmarillas;

}
