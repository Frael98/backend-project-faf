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

    public Integer getId_equipo() {
        return Id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        Id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Partido getPartido_rival() {
        return partido_rival;
    }

    public void setPartido_rival(Partido partido_rival) {
        this.partido_rival = partido_rival;
    }

    public Partido getPartido_local() {
        return partido_local;
    }

    public void setPartido_local(Partido partido_local) {
        this.partido_local = partido_local;
    }

    
}
