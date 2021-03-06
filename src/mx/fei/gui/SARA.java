/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mx.fei.DAO.VehiculoDAO;
import mx.fei.domain.Vehiculo;

/**
 *
 * @author adolf
 */
public class SARA extends Application {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        
        Scene scene = new Scene(root);
        
        PrincipalController.stageController(stage);
        stage.setScene(scene);
        stage.getIcons().add(new Image("mx/fei/images/logo.png"));
        stage.show();
    }
    
}
