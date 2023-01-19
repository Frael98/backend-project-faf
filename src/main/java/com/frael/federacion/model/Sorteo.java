package com.frael.federacion.model;

public class Sorteo extends Entidad{
    
    protected Integer id_sorteo;
    protected Arbitro arbitroEncargado;
    protected Arbitro sustituto;
    protected Partido partido;

    public String notificarArbitro(){
        return "";
    }
}
