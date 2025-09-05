package com.frael.federacion.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Arbitro extends EUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Integer id_arbitro;

    @Column(columnDefinition = "")
    protected String direccion;
    @Column(columnDefinition = "")
    protected String categoria;
    @Column(columnDefinition = "")
    protected Date fechaNacimiento;
    @Column(columnDefinition = "")
    protected String nacionalidad;
    @Column(columnDefinition = "")
    protected String partidos;

    @OneToOne(mappedBy = "arbitroEncargado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Sorteo arbitro_id;

    @OneToOne(mappedBy = "arbitroSustituto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Sorteo arbitro_s_id;
    
}
