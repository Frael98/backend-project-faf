package com.frael.federacion.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Entidad {
    
    @NotNull
    @Column(name = "createdAt", columnDefinition = "datetime default getdate()", nullable = false)
    protected final Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @NotNull
    @Column(name = "updatedAt", columnDefinition = "datetime")
    protected Timestamp updatedAt;

    @NotNull
    @Column(name = "deleteAt", columnDefinition = "datetime")
    protected Timestamp deletedAt;

    @NotNull
    @Column(name = "estado", columnDefinition = "varchar(2) default 'A'")
    protected char estado = 'A';    
}
