/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.domain;

import mx.fei.DAO.FacturaDAO;
import mx.fei.DAO.TarjetaCreditoDAO;

/**
 *
 * @author jethr
 */
public class Usuario {
 
    private String rfc;
    private String nombre;
    private String apellidos;
    private String municipio;
    private String estado;
    private String calleDireccion;
    private String colDireccion;
    private int numDireccion;
    private String codigoPostal;
    private String email;
    private String telefono;
    private String contrasena;
    
    public Usuario(){
        
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCalleDireccion() {
        return calleDireccion;
    }

    public void setCalleDireccion(String calleDireccion) {
        this.calleDireccion = calleDireccion;
    }

    public String getColDireccion() {
        return colDireccion;
    }

    public void setColDireccion(String colDireccion) {
        this.colDireccion = colDireccion;
    }

    public int getNumDireccion() {
        return numDireccion;
    }

    public void setNumDireccion(int numDireccion) {
        this.numDireccion = numDireccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public boolean realizarCompra(Vehiculo vehiculo, TarjetaCredito credito, String metodoPago, int diasRenta, boolean factura){
        boolean pagoExitoso = false;
        double montoPago = vehiculo.getPrecioDia() * diasRenta;
        switch(metodoPago){
            case "deposito":
                pagoExitoso = pagoPorDeposito(vehiculo);
                break;
            case "transaccion":
                pagoExitoso = pagoPorTransaccion(vehiculo);
                break;
            case "tarjeta":
                pagoExitoso = pagoPorTarjetaCredito(vehiculo, credito, montoPago);
                break;
            default:         
        }
        
        if(factura){
            if(pagoExitoso){
                generarFactura(vehiculo, montoPago, diasRenta);
            }
        }
        
        return pagoExitoso;
       
    }
    
    public boolean pagoPorDeposito(Vehiculo vehiculo){
        boolean pagoExitoso = true;
        
        return pagoExitoso;
    }
    
    public boolean pagoPorTransaccion(Vehiculo vehiculo){
        boolean pagoExitoso = true;
        
        return pagoExitoso;
    }
    
    public boolean pagoPorTarjetaCredito(Vehiculo vehiculo, TarjetaCredito credit, double montoPago){
        TarjetaCreditoDAO creditDAO = new TarjetaCreditoDAO();
        creditDAO.agregarTarjetaCredito(credit, rfc);
        
        return Banco.realizarPagoTarjeta(credit, montoPago);
    }
    
    public void generarFactura(Vehiculo vehiculo, double montoPago, int diasRenta){
        Factura factura = new Factura();
        FacturaDAO facturaDAO = new FacturaDAO();
        
        factura.vehiculo = vehiculo;
        factura.setDiasRenta(diasRenta);
        factura.setConcepto("Renta de vehiculo:" + vehiculo.getMarca() + " " + vehiculo.getModelo());
        factura.setDireccionAlmacenamiento("");
        factura.setLugarEntrega(" ");
        factura.setTotalImpuestosAñadidos(0.0);
        factura.setNumeroFactura(0);
        
        facturaDAO.crearFactura(factura);
    }
    
    
}
