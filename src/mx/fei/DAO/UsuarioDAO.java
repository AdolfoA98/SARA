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
import mx.fei.domain.Usuario;

/**
 *
 * @author jethr
 */
public class UsuarioDAO implements IUsuarioDAO {

    public UsuarioDAO() {
        
    }
    
    private List<Usuario> listaUsuarios;
    private String query;
    private Connection connection;
    
    @Override
    public List<Usuario> ObtenerTodoslosCliente() {
        listaUsuarios= new  ArrayList<>();
        query = "Select * from usuario";
        connection = DB.getDataBaseConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result= statement.executeQuery();
            while(result.next()){
                Usuario usuario = new Usuario();
                usuario.setNombre(result.getString("nombre"));
                listaUsuarios.add(usuario);
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            DB.closeConnection();
        }
        return listaUsuarios;
    }

    @Override
    public List<Usuario> obtenerClientePorNombre(String nombreCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtenerClientePorMatricula(String MatriculaCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarCliente(Usuario cliente, String tarjetaCredito ) {
      
        boolean agregado = false;
        query = "insert into agendadb.contacto values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        connection = DB.getDataBaseConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,cliente.getRfc());
            statement.setString(2,cliente.getNombre());
            statement.setString(3,cliente.getApellidos());
            statement.setString(4,cliente.getMunicipio());
            statement.setString(5,cliente.getEstado());
            statement.setString(6,cliente.getCalleDireccion());
            statement.setString(7,cliente.getColDireccion());
            statement.setInt(8,cliente.getNumDireccion());
            statement.setString(9, cliente.getCodigoPostal());
            statement.setString(10, cliente.getEmail());
            statement.setString(11, cliente.getTelefono());
            statement.setString(12, cliente.getContrasena());
            statement.setString(13, tarjetaCredito);
            statement.execute();
            agregado = true;
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            DB.closeConnection();
        }
        return agregado;
        
        
    }

  
    
}
