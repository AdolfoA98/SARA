/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.administracion.vehiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class TarjetaCreditoDAO implements ITarjetaCreditoDAO{
    private String query;
    private Connection connection;
    java.util.Date d = new java.util.Date();  
    SimpleDateFormat plantilla = new SimpleDateFormat("dd/MM/yyyy H:mm");
    String tiempo = plantilla.format(d);
    java.sql.Date date2 = new java.sql.Date(d.getTime());
    
    @Override
    public boolean agregarTarjetaCredito(TarjetaCredito credit, String rfc){
        connection = DataBase.getDataBaseConnection();
        query = "insert into factura (idTarjetaCredito, numeroTarjeta, cuatroDigitos, mesCaducidad, anoCaducidad, ccv, nombreTarjeta, Usuario_rfc )"
              + "values (?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, String.valueOf(credit.getNumeroTarjeta()));
            statement.setInt(2, credit.getNumeroTarjeta());
            statement.setString(3, credit.getCuatroDigitos());
            statement.setInt(4, credit.getMesCaducidad());
            statement.setInt(5, credit.getAnoCaducidad());
            statement.setInt(6, credit.getCcv());
            statement.setString(7, credit.getNombreTarjeta());
            statement.setString(8, rfc);
            
            statement.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
