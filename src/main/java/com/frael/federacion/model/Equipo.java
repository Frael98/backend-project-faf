package com.frael.federacion.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Entity
public class Equipo extends Entidad{
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    protected Long id_equipo;
    
    @NotNull(message = "El nombre del equipo no puede ser vacío")
    @Column
    protected String nombre;
    
    @NotNull(message = "El nombre del director no puede ser nulo")
    @Column
    protected String director;

    @OneToMany( mappedBy = "equipoRival", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("equipo-partido-rival") // El nombre de estas referencias no fueron agregadas en las pruebas con post y daba error  com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Multiple back-reference properties with name 'defaultReference'
    protected Set<Partido> partido_rival;

    @JsonManagedReference("equipo-partido-local")
    @OneToMany( mappedBy = "equipoLocal",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected Set<Partido> partido_local; //@OneToMany: Esto indica que un equipo puede estar asociado a muchos partidos.
    
}
