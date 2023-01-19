package com.frael.federacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Equipo extends Entidad{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    protected Integer Id_equipo;
    @Column
    protected String nombre;
    @Column
    protected String director;
}
