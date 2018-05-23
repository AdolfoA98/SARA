/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.DAO;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
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
    public boolean agregarAuto(Vehiculo vehiculo, String rfcCliente, String flotilla) {
     
       boolean agregado = false;
       query = "insert into vehiculo value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
           
           
           statement.execute();
           agregado=true;
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
                if("si".equals(result.getString("climatizado"))){
                    vehiculo.setClimatizado(1);
                }else{
                    vehiculo.setClimatizado(2);
                }
                if("manual".equals(result.getString("transmision"))){
                    vehiculo.setTransmision(1);
                }else{
                    vehiculo.setTransmision(2);
                }
                vehiculo.setNumPasajeros(result.getInt("numPasajeros"));
                vehiculo.setNumPuertas(result.getInt("numPuertas"));
                vehiculo.setMarca(result.getString("marca"));
                vehiculo.setModelo(result.getString("modelo"));
                vehiculo.setVersion(result.getString("version"));
                vehiculo.setKilometraje(result.getDouble("kilometraje"));
                vehiculo.setKml(result.getDouble("kml"));
                if("si".equals(result.getString("gps"))){
                    vehiculo.setGps(1);
                }else{
                    vehiculo.setGps(2);
                }
                vehiculo.setDescripcion(result.getString("descripcion"));
                vehiculo.setEstado(Integer.parseInt(result.getString("estado")));
                if("disponible".equals(result.getString("disponibilidad"))){
                    vehiculo.setDisponibilidad(1);
                }else{
                    vehiculo.setDisponibilidad(2);
                }
                vehiculo.setPrecioDia(result.getDouble("precioDia"));
                vehiculo.setThumbnail(result.getString("Thumbnail"));
                listaVehiculos.add(vehiculo);
            }
        }catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            DB.closeConnection();
        }
        System.out.println(listaVehiculos.get(0));
        return listaVehiculos;
    }
    
}
