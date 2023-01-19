package com.frael.federacion.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidad {
    
    @Column(name = "estado", columnDefinition = "nvarchar default 'A'")
    protected char estado = 'A';
    @Column(name = "createdAt", columnDefinition = "datetime default getdate()", nullable = false)
    protected final Date createdAt = new Date(System.currentTimeMillis());
    @Column(name = "updatedAt", columnDefinition = "datetime")
    protected Date updateAt;
    @Column(name = "deleteAt", columnDefinition = "datetime")
    protected Date deleteAt;

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
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    
}
