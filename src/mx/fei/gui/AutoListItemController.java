/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import java.util.logging.Logger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mx.fei.domain.Vehiculo;

/**
 * FXML Controller class
 *
 * @author adolf
 */
public class AutoListItemController{
    
    private Vehiculo vehiculo;
    
    @FXML
    private HBox autoItem;
    
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
    
    public AutoListItemController(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AutoListItem.fxml"));
        loader.setController(this);
        
        try{
            autoItem = loader.load();
        }catch(IOException ex){
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setInformacion(Vehiculo vehiculo){
        
        this.vehiculo = vehiculo;
        
        System.out.println(this.vehiculo.getThumbnail());
        
        imagenAuto.setImage(new Image(vehiculo.getThumbnail()));
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
    public void cargarDescripcion(){
        
        Stage stage = new Stage();
        RentarAutoController controller = new RentarAutoController();
        Parent root = controller.load();
           
        Scene scene = new Scene(root);
           
        controller.setInfo(vehiculo);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setOnCloseRequest((WindowEvent t) -> {
            Platform.exit();
            System.exit(0);
        });
        stage.getIcons().add(new Image("mx/fei/images/logo.png"));
        stage.show();
    }
    
    public HBox getBox(){
        return autoItem;
    }
}
