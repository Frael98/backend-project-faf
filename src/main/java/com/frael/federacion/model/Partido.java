package com.frael.federacion.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Partido extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id_partido;

    @OneToOne(mappedBy = "partido_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected ActaPartido actaPartido;

    @OneToOne(mappedBy = "partido_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Agenda agenda;

    @OneToOne(mappedBy = "partido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Sorteo sorteo;

    @OneToOne
    @JoinColumn(name = "equipo_rival_id")
    protected Equipo equipoRival;
     
    @OneToOne
    @JoinColumn(name = "equipo_local_id")
    protected Equipo equipoLocal;

    @Column
    protected String partido_descripcion;

    public Integer getId_partido() {
        return id_partido;
    }

    public void setId_partido(Integer id_partido) {
        this.id_partido = id_partido;
    }

    public ActaPartido getActaPartido() {
        return actaPartido;
    }

    public void setActaPartido(ActaPartido actaPartido) {
        this.actaPartido = actaPartido;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Sorteo getSorteo() {
        return sorteo;
    }

    public void setSorteo(Sorteo sorteo) {
        this.sorteo = sorteo;
    }

    public Equipo getEquipoRival() {
        return equipoRival;
    }

    public void setEquipoRival(Equipo equipoRival) {
        this.equipoRival = equipoRival;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getPartido_descripcion() {
        return partido_descripcion;
    }

    public void setPartido_descripcion(String partido_descripcion) {
        this.partido_descripcion = partido_descripcion;
    }


}
