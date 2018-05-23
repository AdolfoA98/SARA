/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.domain;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import mx.fei.DS.DB;
import mx.fei.domain.Factura;
import mx.fei.DAO.IFacturaDAO;

/**
 *
 * @author dell
 */
public class FacturaDAO implements IFacturaDAO {

    private String query;
    private Connection connection;
    java.util.Date d = new java.util.Date();  
    SimpleDateFormat plantilla = new SimpleDateFormat("dd/MM/yyyy H:mm");
    String tiempo = plantilla.format(d);
    java.sql.Date date2 = new java.sql.Date(d.getTime());
    
    @Override
    public boolean crearFactura(Factura factura){
        connection = DB.getDataBaseConnection();
        query = "insert into factura (numeroFactura, fechaFacturacion, concepto, totalImpuestosAñadidos, direccionAlmacenamiento, diasRenta, Vehiculo_noMotor, Usuario_rfc)"
              + "values (?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, generarNumeroFactura(Integer.getInteger(factura.vehiculo.getNoMotor())));
            statement.setDate(2, date2);
            statement.setString(3, factura.getConcepto());
            statement.setDouble(4, calcularImpuestos(factura.vehiculo.getPrecioDia(), factura.getDiasRenta()));
            statement.setString(5, "");
            statement.setInt(6, factura.getDiasRenta());
            statement.setString(7, factura.vehiculo.getNoMotor());
            statement.setString(8, factura.usuario.getRfc());
            
            statement.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private int generarNumeroFactura(int nomotor){
        int numeroFactura;
        numeroFactura = nomotor + 100 ;
        
        return numeroFactura;
    }
    private double calcularImpuestos(double precioDia, int diasRenta){
        return (precioDia * diasRenta)*1.16;
    }
}
