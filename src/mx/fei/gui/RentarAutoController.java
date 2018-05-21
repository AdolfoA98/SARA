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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mx.fei.domain.Vehiculo;

/**
 * FXML Controller class
 *
 * @author adolf
 */
public class RentarAutoController{
    
    private static Vehiculo vehiculo;
    private FXMLLoader loader;
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    private ImageView imagenAuto;
    
    @FXML
    private Label titulo;
    
    @FXML
    private Label marca;
    
    @FXML
    private Label modelo;
    
    @FXML
    private Label textoAire;
    
    @FXML
    private ImageView imagenTransmision;
    
    @FXML
    private Label textoTransmision;
    
    @FXML
    private Label pasajeros;
    
    @FXML
    private Label puertasAuto;
    
    @FXML
    private Label disponibilidad;
    
    @FXML
    private Label precioDia;
    
    @FXML
    private Label precioTotal;
    
    @FXML
    private JFXButton botonRegresar;
    
    public RentarAutoController(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RentarAuto.fxml"));
        loader.setController(this);
        this.loader = loader;
    }
    
    public Parent load(){
        try{
            return loader.load();
        }catch(IOException ex){
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public GridPane getLoader(){
        return this.gridPane;
    }
    
    public void setInfo(Vehiculo auto){
        vehiculo = auto;
        
        imagenAuto.setImage(new Image(auto.getThumbnail()));
        titulo.setText(vehiculo.getDescripcion());
        marca.setText(vehiculo.getMarca());
        modelo.setText(vehiculo.getModelo());
        
        if(vehiculo.getClimatizado() == 1){
            textoAire.setText("C/AC");
        }else{
            textoAire.setText("S/AC");
        }
        
        if(vehiculo.getTransmision() == 1){
            imagenTransmision.setImage(new Image("mx/fei/images/transmission.png"));
            textoTransmision.setText("M");
        }else{
            imagenTransmision.setImage(new Image("mx/fei/images/transmissionA.png"));
            textoTransmision.setText("A");
        }
        
        pasajeros.setId(Integer.toString(vehiculo.getNumPasajeros()));
        puertasAuto.setText(Integer.toString(vehiculo.getNumPuertas()));
        
        if(vehiculo.getDisponibilidad() == 1){
            disponibilidad.setText("Disponible");
        }else{
            disponibilidad.setText("No disponible");
        }
        
        precioDia.setText("MXN $" + Double.toString(vehiculo.getPrecioDia()));
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
    public void regresarVentana(ActionEvent evento){
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PrincipalAutos.fxml"));
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                System.exit(0);
            });
            stage.getIcons().add(new Image("mx/fei/images/logo.png"));
            stage.show();
            
            Stage actualStage = (Stage) botonRegresar.getScene().getWindow();
            actualStage.close();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void cargarVenta(){
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Renta.fxml"));
            
            Scene scene = new Scene(root);
            
            RentaController.setInfo(vehiculo);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new Image("mx/fei/images/logo.png"));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
