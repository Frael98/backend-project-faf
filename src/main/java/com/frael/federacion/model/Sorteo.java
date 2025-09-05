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
    
    
    public Integer getId_sorteo() {
        return id_sorteo;
    }


    public void setId_sorteo(Integer id_sorteo) {
        this.id_sorteo = id_sorteo;
    }


    public Arbitro getArbitroEncargado() {
        return arbitroEncargado;
    }


    public void setArbitroEncargado(Arbitro arbitroEncargado) {
        this.arbitroEncargado = arbitroEncargado;
    }


    public Arbitro getArbitroSustituto() {
        return arbitroSustituto;
    }


    public void setArbitroSustituto(Arbitro arbitroSustituto) {
        this.arbitroSustituto = arbitroSustituto;
    }


    public Partido getPartido() {
        return partido;
    }


    public void setPartido(Partido partido) {
        this.partido = partido;
    }


    public Date getFechaSorteo() {
        return fechaSorteo;
    }


    public void setFechaSorteo(Date fechaSorteo) {
        this.fechaSorteo = fechaSorteo;
    }

    public String notificarArbitro() {
        return "";
    }
}
