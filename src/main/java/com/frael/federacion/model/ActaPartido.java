package com.frael.federacion.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ActaPartido extends Entidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Integer Id_acta;
    @Column
    protected String codigoActa;

    // id de partido
    @OneToOne
    @JoinColumn(name = "partido_id")
    protected Partido partido_id;

    @Column
    protected Date fechaEmision;
    @Column
    protected Integer cantTarjetasRojas;
    @Column
    protected Integer cantTarjetasAmarillas;

}
