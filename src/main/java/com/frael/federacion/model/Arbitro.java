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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPartidos() {
        return partidos;
    }

    public void setPartidos(String partidos) {
        this.partidos = partidos;
    }

    public Integer getId_arbitro() {
        return id_arbitro;
    }

}
