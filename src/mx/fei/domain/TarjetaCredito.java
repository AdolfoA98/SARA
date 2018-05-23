/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.domain;

/**
 *
 * @author jethr
 */
public class TarjetaCredito {
    
    private String idTarjeta;
    private int numeroTarjeta;
    private String cuatroDigitos;
    private int mesCaducidad;
    private int anioCaducidad;
    private int ccv;
    private String nombreTarjeta;
    
    TarjetaCredito() {
        
    }

    public String getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(String idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCuatroDigitos() {
        return cuatroDigitos;
    }

    public void setCuatroDigitos(String cuatroDigitos) {
        this.cuatroDigitos = cuatroDigitos;
    }

    public int getMesCaducidad() {
        return mesCaducidad;
    }

    public void setMesCaducidad(int mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }

    public int getAnioCaducidad() {
        return anioCaducidad;
    }

    public void setAnioCaducidad(int anioCaducidad) {
        this.anioCaducidad = anioCaducidad;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }
    
    
}
