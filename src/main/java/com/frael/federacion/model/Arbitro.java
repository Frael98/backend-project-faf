package com.frael.federacion.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Arbitro extends Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    protected Integer id_arbitro;

    @Column(columnDefinition = "")
    protected String peso;
    @Column(columnDefinition = "")
    protected String categoria;
    @Column(columnDefinition = "")
    protected String funcion;
    @Column(columnDefinition = "")
    protected String altura;
    @Column(columnDefinition = "")
    protected String direccion;
    @Column(columnDefinition = "")
    protected Date fechaNacimiento;
    @Column(columnDefinition = "")
    protected String nacionalidad;
    @Column(columnDefinition = "")
    protected String partidos;
    @Column(columnDefinition = "")
    protected String anioDebut;
    @Column(columnDefinition = "")
    protected String comite;
    
    
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getFuncion() {
        return funcion;
    }
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    public String getAltura() {
        return altura;
    }
    public void setAltura(String altura) {
        this.altura = altura;
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
    public String getAnioDebut() {
        return anioDebut;
    }
    public void setAnioDebut(String anioDebut) {
        this.anioDebut = anioDebut;
    }
    public String getComite() {
        return comite;
    }
    public void setComite(String comite) {
        this.comite = comite;
    }
    public Integer getId_arbitro() {
        return id_arbitro;
    }

    
}
