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
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ActaPartido extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Long Id_acta;
    @Column
    protected String codigoActa;

    // id de partido
    @OneToOne
    @JoinColumn(name = "partido_id")
    protected Partido partido_id;

    @Column
    protected Date fechaEmision;

    @Column
    protected Date hora_inicio;

    @Column
    protected Date hora_fin;

    @Column
    protected String equipo_local;
    @Column
    protected String equipo_rival;

    @Column
    protected Time duracion_partido;

    @Column
    protected int num_gol_equipo_local;

    @Column
    protected int num_gol_equipo_rival;

    @Column
    protected String equipoGanador;
    
    @Column
    protected Integer totalRojas;
    @Column
    protected Integer totalAmarillas;

    @Column
    protected Integer localAmarillas;
    @Column
    protected Integer rivalAmarillas;

    @Column
    protected Integer localRojas;
    @Column
    protected Integer rivalRojas;

}
