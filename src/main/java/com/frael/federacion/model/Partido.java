package com.frael.federacion.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Partido {

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


}
