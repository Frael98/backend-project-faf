package com.frael.federacion.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ActaPartido extends Entidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Integer Id_acta;
    @Column
    protected String codigoActa;

    @OneToOne(mappedBy = "acta_partido", cascade = CascadeType.ALL)
    protected Partido partido;
    @Column
    protected Date fechaEmision;
    @Column
    protected Integer cantTarjetasRojas;
    @Column
    protected Integer cantTarjetasAmarillas;

}
