/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.administracion.vehiculos;

/**
 *
 * @author dell
 */
public class TarjetaCredito {
    private String idTarjetaCredito;
    private int numeroTarjeta;
    private String cuatroDigitos;
    private int mesCaducidad;
    private int anoCaducidad;
    private int ccv;
    private String nombreTarjeta;

    public String getIdTarjetaCredito() {
        return idTarjetaCredito;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getCuatroDigitos() {
        return cuatroDigitos;
    }

    public int getMesCaducidad() {
        return mesCaducidad;
    }

    public int getAnoCaducidad() {
        return anoCaducidad;
    }

    public int getCcv() {
        return ccv;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    
    public void setIdTarjetaCredito(String idTarjetaCredito) {
        this.idTarjetaCredito = idTarjetaCredito;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setCuatroDigitos(String cuatroDigitos) {
        this.cuatroDigitos = cuatroDigitos;
    }

    public void setMesCaducidad(int mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }

    public void setAnoCaducidad(int anoCaducidad) {
        this.anoCaducidad = anoCaducidad;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }
    
    
}
