package com.frael.federacion.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Asistencia extends Entidad{
    /**
     * Clave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id_asistencia;

    @Column()
    protected Integer id_abitro;
    @Column
    protected Boolean asistio;
    @Column
    protected String lugar;
    @Column
    protected String partido;
    @Column
    protected Date fechaConfirmacion;

    // Getters & Setters
    public Integer getId_asistencia() {
        return id_asistencia;
    }
    public void setId_asistencia(Integer id_asistencia) {
        this.id_asistencia = id_asistencia;
    }
    public Integer getId_abitro() {
        return id_abitro;
    }
    public void setId_abitro(Integer id_abitro) {
        this.id_abitro = id_abitro;
    }
    public Boolean getAsistio() {
        return asistio;
    }
    public void setAsistio(Boolean asistio) {
        this.asistio = asistio;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public String getPartido() {
        return partido;
    }
    public void setPartido(String partido) {
        this.partido = partido;
    }
    public Date getFechaConfirmacion() {
        return fechaConfirmacion;
    }
    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    
}
