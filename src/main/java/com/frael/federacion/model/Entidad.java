package com.frael.federacion.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidad {
    
    @Column(name = "createdAt", columnDefinition = "datetime default getdate()", nullable = false)
    protected final Date createdAt = new Date(System.currentTimeMillis());
    @Column(name = "updatedAt", columnDefinition = "datetime")
    protected Date updatedAt;
    @Column(name = "deleteAt", columnDefinition = "datetime")
    protected Date deletedAt;
    @Column(name = "estado", columnDefinition = "varchar(2) default 'A'")
    protected char estado = 'A';

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado){
        this.estado = estado;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdateAt() {
        return updatedAt;
    }

    public void setUpdateAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeleteAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    
}
