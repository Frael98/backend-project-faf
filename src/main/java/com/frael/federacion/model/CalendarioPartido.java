package com.frael.federacion.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CalendarioPartido extends Entidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Integer id;
    protected String equipoLocal;
    protected String equipoRival;
    protected String lugarPartido;
    protected Time horaPartido;
    protected Date fechaPartido;
    protected char estado;
}
