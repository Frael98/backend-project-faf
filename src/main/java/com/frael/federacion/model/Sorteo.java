package com.frael.federacion.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@Entity
public class Sorteo extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id_sorteo;

    @OneToOne
    @JoinColumn(name = "arbitro_id")
    protected Arbitro arbitroEncargado;

    @OneToOne
    @JoinColumn(name = "arbitro_sustituto_id")
    protected Arbitro arbitroSustituto;

    @OneToOne
    @JoinColumn(name = "partido_id")
    protected Partido partido;
    
    @Column
    protected Date fechaSorteo;
    
    public String notificarArbitro() {
        return "";
    }
}
