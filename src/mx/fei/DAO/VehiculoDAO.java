/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.DS.DB;

import mx.fei.domain.Vehiculo;

/**
 *
 * @author jethr
 */
public class VehiculoDAO implements IVehiculoDAO {
    
    public VehiculoDAO() {
    
    }
    
    private List<Vehiculo> listaVehiculos;
    private String query;
    private Connection connection;

    @Override
    public boolean agregarAuto(Vehiculo vehiculo, String rfcCliente, String flotilla, String matriculaAdmi) {
     
       boolean agregado = false;
       query = "insert into vehiculo value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       connection = DB.getDataBaseConnection();
       
       
       try {
           PreparedStatement statement = connection.prepareStatement(query);
           
           statement.setString(1, vehiculo.getNoMotor());
           statement.setInt(2, vehiculo.getClimatizado());
           statement.setInt(3, vehiculo.getTransmision());
           statement.setInt(4, vehiculo.getNumPasajeros());
           statement.setInt(5, vehiculo.getNumPuertas());
           statement.setString(6, vehiculo.getMarca());
           statement.setString(7, vehiculo.getModelo());
           statement.setString(8, vehiculo.getVersion());
           statement.setDouble(9, vehiculo.getKilometraje());
           statement.setDouble(10, vehiculo.getKml());
           statement.setInt(11, vehiculo.getGps());
           statement.setString(12, vehiculo.getDescripcion());
           statement.setInt(13, vehiculo.getEstado());
           statement.setInt(14, vehiculo.getDisponibilidad());
           statement.setString(15, flotilla);
           statement.setDouble(16, vehiculo.getPrecioDia());
           statement.setString(17, vehiculo.getThumbnail());
           statement.setString(18, rfcCliente);
           statement.setString(19, matriculaAdmi);
           
           
       } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
         DB.closeConnection();
       }
       return agregado;
    }

    @Override
    public boolean eliminarAuto(String noMotor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        listaVehiculos= new  ArrayList<>();
        query = "Select * from vehiculo";
        connection = DB.getDataBaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result= statement.executeQuery();
            while(result.next()){
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setNoMotor(result.getString("noMotor"));
               
                listaVehiculos.add(vehiculo);
            }
        }catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            DB.closeConnection();
        }
        return listaVehiculos;
    }
    
}
