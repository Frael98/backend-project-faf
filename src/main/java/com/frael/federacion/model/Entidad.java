package com.frael.federacion.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Entidad {
    
    @Column(name = "createdAt", columnDefinition = "datetime default getdate()", nullable = false)
    protected Timestamp createdAt;

    @Column(name = "updatedAt", columnDefinition = "datetime")
    protected Timestamp updatedAt;

    @Column(name = "deleteAt", columnDefinition = "datetime")
    protected Timestamp deletedAt;

    @NotNull
    @Column(name = "estado", columnDefinition = "varchar(2) default 'A'")
    protected char estado = 'A';

     // --- Métodos de ciclo de vida ---
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
