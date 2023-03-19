package com.frael.federacion.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


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

    @OneToOne
    @JoinColumn(name = "partido_id")
    protected Partido partido_id;

    public Integer getId_agenda() {
        return Id_agenda;
    }

    public void setId_agenda(Integer id_agenda) {
        Id_agenda = id_agenda;
    }

    public String getLugarPartido() {
        return lugarPartido;
    }

    public void setLugarPartido(String lugarPartido) {
        this.lugarPartido = lugarPartido;
    }

    public Time getHoraPartido() {
        return horaPartido;
    }

    public void setHoraPartido(Time horaPartido) {
        this.horaPartido = horaPartido;
    }

    public Date getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public Partido getPartido_id() {
        return partido_id;
    }

    public void setPartido_id(Partido partido_id) {
        this.partido_id = partido_id;
    }

    

}
