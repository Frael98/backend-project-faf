package com.frael.federacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Partido {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    protected Integer id_partido;

    @JoinColumn( referencedColumnName = "")
    protected Agenda agenda;

    @Column
    protected Equipo equipoRival;
    @Column
    protected Equipo equipoLocal;
    @Column
    protected Sorteo sorteo;

    @OneToOne(fetch = FetchType.EAGER)
    protected ActaPartido acta_partido;

}
