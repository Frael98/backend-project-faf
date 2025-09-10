package com.frael.federacion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
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

    @ManyToOne
    @JsonBackReference("equipo-partido-rival")
    @JoinColumn(name = "equipo_rival_id")
    protected Equipo equipoRival;
     
    @ManyToOne //@ManyToOne: Esto indica que muchos partidos pueden estar relacionados con un solo equipo.
    @JsonBackReference("equipo-partido-local")
    @JoinColumn(name = "equipo_local_id")
    protected Equipo equipoLocal;

    @Column
    protected String partido_descripcion;

}
