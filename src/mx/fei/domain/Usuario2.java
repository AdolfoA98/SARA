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
public class Usuario {
    private String rfc;
    private String nombre;
    TarjetaCreditoDAO  tarjetaDAO;

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

    public boolean realizarCompra(Vehiculo vehiculo, String metodoPago){
        boolean pagoExitoso = false;
        switch(metodoPago){
            case "deposito":
                pagoPorDeposito(vehiculo);
                break;
            case "transaccion":
                pagoPorTransaccion(vehiculo);
                break;
            case "tarjeta":
                pagoPorTarjetaCredito(vehiculo);
                break;
            default:
                return false;
                
        }
        return false;
    }
    
    public boolean pagoPorDeposito(Vehiculo vehiculo){
        boolean pagoExitoso = false;
        
        return pagoExitoso;
    }
    
    public boolean pagoPorTransaccion(Vehiculo vehiculo){
        boolean pagoExitoso = false;
        
        return pagoExitoso;
    }
    
    public boolean pagoPorTarjetaCredito(Vehiculo vehiculo, TarjetaCredito credit){
        boolean pagoExitoso = false;
        Factura facturaRenta = new Factura();
        tarjetaDAO = new TarjetaCreditoDAO();
        
          
        
        return pagoExitoso;
    }
    
}
