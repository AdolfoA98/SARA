/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adolf
 */
public class LoginController implements Initializable {

    @FXML
    private JFXButton botonRegresar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void cerrarVentana(ActionEvent evento){
        Stage stage = (Stage) botonRegresar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void cargarPAdministrador(){
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PrincipalAdministrador.fxml"));
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new Image("mx/fei/images/logo.png"));
            Stage actualStage = (Stage) botonRegresar.getScene().getWindow();
            actualStage.close();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
