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
    public Date getHora_inicio() {
        return hora_inicio;
    }
    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
    public Date getHora_fin() {
        return hora_fin;
    }
    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
    }
    public String getEquipo_local() {
        return equipo_local;
    }
    public void setEquipo_local(String equipo_local) {
        this.equipo_local = equipo_local;
    }
    public String getEquipo_rival() {
        return equipo_rival;
    }
    public void setEquipo_rival(String equipo_rival) {
        this.equipo_rival = equipo_rival;
    }
    public Time getDuracion_partido() {
        return duracion_partido;
    }
    public void setDuracion_partido(Time duracion_partido) {
        this.duracion_partido = duracion_partido;
    }
    public int getNum_gol_equipo_local() {
        return num_gol_equipo_local;
    }
    public void setNum_gol_equipo_local(int num_gol_equipo_local) {
        this.num_gol_equipo_local = num_gol_equipo_local;
    }
    public int getNum_gol_equipo_rival() {
        return num_gol_equipo_rival;
    }
    public void setNum_gol_equipo_rival(int num_gol_equipo_rival) {
        this.num_gol_equipo_rival = num_gol_equipo_rival;
    }
    public String getEquipoGanador() {
        return equipoGanador;
    }
    public void setEquipoGanador(String equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    

}
