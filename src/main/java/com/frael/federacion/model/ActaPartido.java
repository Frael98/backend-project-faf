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
    
    public Integer getId_acta() {
        return Id_acta;
    }
    public void setId_acta(Integer id_acta) {
        Id_acta = id_acta;
    }
    public String getCodigoActa() {
        return codigoActa;
    }
    public void setCodigoActa(String codigoActa) {
        this.codigoActa = codigoActa;
    }
    public Partido getPartido_id() {
        return partido_id;
    }
    public void setPartido_id(Partido partido_id) {
        this.partido_id = partido_id;
    }
    public Date getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public Integer getTotalRojas() {
        return totalRojas;
    }
    public void setTotalRojas(Integer totalRojas) {
        this.totalRojas = totalRojas;
    }
    public Integer getTotalAmarillas() {
        return totalAmarillas;
    }
    public void setTotalAmarillas(Integer totalAmarillas) {
        this.totalAmarillas = totalAmarillas;
    }
    public Integer getLocalAmarillas() {
        return localAmarillas;
    }
    public void setLocalAmarillas(Integer localAmarillas) {
        this.localAmarillas = localAmarillas;
    }
    public Integer getRivalAmarillas() {
        return rivalAmarillas;
    }
    public void setRivalAmarillas(Integer rivalAmarillas) {
        this.rivalAmarillas = rivalAmarillas;
    }
    public Integer getLocalRojas() {
        return localRojas;
    }
    public void setLocalRojas(Integer localRojas) {
        this.localRojas = localRojas;
    }
    public Integer getRivalRojas() {
        return rivalRojas;
    }
    public void setRivalRojas(Integer rivalRojas) {
        this.rivalRojas = rivalRojas;
    }

    

}
