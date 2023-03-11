package com.frael.federacion.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Equipo extends Entidad{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    protected Integer Id_equipo;
    @Column
    protected String nombre;
    @Column
    protected String director;

    @OneToOne( mappedBy = "equipoRival", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Partido partido_rival;

    @OneToOne( mappedBy = "equipoLocal",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Partido partido_local;
}
