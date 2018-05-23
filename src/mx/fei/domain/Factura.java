/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.domain;

import java.util.Date;

/**
 *
 * @author dell
 */
public class Factura {
    private int numeroFactura;
    private Date fechaFacturacion;
    private String concepto;
    private double totalImpuestosAñadidos;
    private String direccionAlmacenamiento;
    private int diasRenta;
    private String lugarEntrega;
    
    public Vehiculo vehiculo = new Vehiculo();
    public Usuario usuario = new Usuario();

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getTotalImpuestosAñadidos() {
        return totalImpuestosAñadidos;
    }

    public void setTotalImpuestosAñadidos(double totalImpuestosAñadidos) {
        this.totalImpuestosAñadidos = totalImpuestosAñadidos;
    }

    public String getDireccionAlmacenamiento() {
        return direccionAlmacenamiento;
    }

    public void setDireccionAlmacenamiento(String direccionAlmacenamiento) {
        this.direccionAlmacenamiento = direccionAlmacenamiento;
    }

    public int getDiasRenta() {
        return diasRenta;
    }

    public void setDiasRenta(int diasRenta) {
        this.diasRenta = diasRenta;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }
    
    
    
}
