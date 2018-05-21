/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author adolf
 */
public class PrincipalController implements Initializable {
    
    public static void stageController(Stage stage){
        stage.setResizable(false);
        stage.setOnCloseRequest((WindowEvent t) -> {
            Platform.exit();
            System.exit(0);
        });
    }

    @FXML
    private ImageView slider;
    
    @FXML
    private JFXComboBox<Label> flotillas;
    
    @FXML
    private JFXButton botonBuscar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        new ThreadImpl().start();
        flotillas.getItems().add(new Label("Xalapa"));
        flotillas.getItems().add(new Label("Veracruz"));
        flotillas.getItems().add(new Label("Puebla"));
        flotillas.getItems().add(new Label("Ciudad de México"));
    }

    @FXML
    public void cargarPaginaLogin(){
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new Image("mx/fei/images/logo.png"));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void cargarPaginaAutos(){
        Stage actualStage = (Stage) botonBuscar.getScene().getWindow();
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PrincipalAutos.fxml"));
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new Image("mx/fei/images/logo.png"));
            stage.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                System.exit(0);
            });
            stage.show();
            actualStage.close();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class ThreadImpl extends Thread {

        @Override
        public void run(){
            
            String[] imagenes = new String[3];
            imagenes[0] = "mx/fei/images/car-star.jpg";
            imagenes[1] = "mx/fei/images/slider2.jpg";
            imagenes[2] = "mx/fei/images/slider3.jpg";
            
            int contador = 0;
            
            while(true){
                try{
                    contador++;
                    if(contador < 3){
                        Thread.sleep(3000);
                        Image nuevaImagen = new Image(imagenes[contador]);
                        slider.setImage(nuevaImagen);
                        FadeTransition fadeOut = new FadeTransition(Duration.millis(3000), slider);
                        fadeOut.setFromValue(0.0);
                        fadeOut.setToValue(1.0);
                        fadeOut.play();
                    }else{
                        contador = -1;
                    }
                }catch(InterruptedException ex){
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
