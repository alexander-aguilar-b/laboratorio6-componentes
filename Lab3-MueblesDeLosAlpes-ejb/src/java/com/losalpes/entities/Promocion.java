/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.entities;

import java.util.Date;

/**
 *
 * @author edgaguil
 */
public class Promocion {
    private String descripcion;
    
    private Date fechaInicio;
    
    private Date fechaFin;
    
    public Promocion() {
        
    }
    public Promocion(String descripcion, Date fechaIni, Date fechaFin) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaIni;
        this.fechaFin = fechaFin;
    } 
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaIni) {
        this.fechaInicio = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }    
}
