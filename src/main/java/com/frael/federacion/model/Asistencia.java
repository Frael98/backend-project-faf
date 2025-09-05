package com.frael.federacion.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
