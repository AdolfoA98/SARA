/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.DS;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jethr
 */
public class DB {
    private static Connection connection;  
    
    private static void makeConnection(){
       
        
        try {
            
            String url= "jdbc:mysql://localhost/";
            String databaseName = "sara-bd";
            String userName = "proyProcessJ";
            String password = "proyProcessJ";
       
            connection = (Connection)DriverManager.getConnection(url+databaseName,userName,password);
           
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public static Connection getDataBaseConnection() {        
        makeConnection();
        return DB.connection;
 
    }
    
    public static void closeConnection(){
        if(connection!=null){
            try {
                if(!connection.isClosed()){
                    connection.close();                
                }
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
