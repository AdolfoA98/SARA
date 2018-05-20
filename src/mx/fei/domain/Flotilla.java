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
public class Flotilla {
    
    private String matriculaFlotilla;
    private String calleDireccion;
    private String coloniaDireccion;
    private String numeroDireccion;
    private String ciudad;
    private String estado;
    private String pais;
    private String codigoPostal;
    
    Flotilla(){
        
    }

    public String getMatriculaFlotilla() {
        return matriculaFlotilla;
    }

    public void setMatriculaFlotilla(String matriculaFlotilla) {
        this.matriculaFlotilla = matriculaFlotilla;
    }

    public String getCalleDireccion() {
        return calleDireccion;
    }

    public void setCalleDireccion(String calleDireccion) {
        this.calleDireccion = calleDireccion;
    }

    public String getColoniaDireccion() {
        return coloniaDireccion;
    }

    public void setColoniaDireccion(String coloniaDireccion) {
        this.coloniaDireccion = coloniaDireccion;
    }

    public String getNumeroDireccion() {
        return numeroDireccion;
    }

    public void setNumeroDireccion(String numeroDireccion) {
        this.numeroDireccion = numeroDireccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
}
