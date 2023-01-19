package com.frael.federacion.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Agenda extends Entidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Integer Id_agenda;
    @Column
    protected String lugarPartido;
    @Column
    protected Time horaPartido;
    @Column
    protected Date fechaPartido;


}
