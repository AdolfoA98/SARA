/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mx.fei.DAO.VehiculoDAO;
import mx.fei.domain.Vehiculo;

/**
 * FXML Controller class
 *
 * @author adolf
 */
public class PrincipalAutosController implements Initializable {

    @FXML
    private JFXButton botonRegresar;
    
    @FXML
    private ListView listaAutos;
    
    private List<Vehiculo> autos;
    
    private ObservableList<Vehiculo> observableAutos;
    
    private VehiculoDAO vehiculoDao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //autos = vehiculoDao.obtenerVehiculos();
        vehiculoDao = new VehiculoDAO();
        autos = vehiculoDao.obtenerVehiculos();
        observableAutos = FXCollections.observableArrayList(autos);
        
        listaAutos.setItems(observableAutos);
        listaAutos.setCellFactory(celdas -> new ListCell<Vehiculo>() {
            
            @Override
            protected void updateItem(Vehiculo vehiculo, boolean vacio) {
                super.updateItem(vehiculo, vacio);

                if (vacio || vehiculo == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    AutoListItemController controller = new AutoListItemController();
                    controller.setInformacion(vehiculo);
                    setGraphic(controller.getBox());
                }
            }
        });
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
            Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                System.exit(0);
            });
            stage.getIcons().add(new Image("mx/fei/images/logo.png"));
            stage.show();
            
            Stage actualStage = (Stage) listaAutos.getScene().getWindow();
            actualStage.close();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
