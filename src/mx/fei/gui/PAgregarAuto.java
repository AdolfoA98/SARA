/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import mx.fei.DAO.VehiculoDAO;
import mx.fei.domain.Vehiculo;

/**
 * FXML Controller class
 *
 * @author jethr
 */
public class PAgregarAuto implements Initializable {
    
    Vehiculo vehiculo = new Vehiculo();
    
    private String motor;
    private int clima;
    private int transmision;
    private int noPasajeros;
    private int noPuertas;
    private String marca;
    private String modelo;
    private String version;
    private double kilometraje;
    private double kml;
    private int gps;
    private String descripcion;
    private int estado;
    private int disponible;
    private String matriculaFlotilla;
    private double precioDia;
    private String Thumbnail;
    private static String clienteRfc;
    
    @FXML
    private Button bAgregar;
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    private TextField txtNoMotor;
    
    @FXML
    private ComboBox boxClima;
    
    @FXML
    private ComboBox boxTransmision;
    
    @FXML
    private TextField txtNoPasajeros;
    
    @FXML
    private TextField txtNoPuertas;
    
    @FXML
    private TextField txtMarca;
    
    @FXML
    private TextField txtModelo;
    
    @FXML
    private TextField txtVersion;
    
    @FXML
    private TextField txtKilometraje;
    
    @FXML
    private TextField txtKml;
    
    @FXML
    private ComboBox boxGps;
    
    @FXML
    private TextArea txtDescripcion;
    
    @FXML
    private TextField txtPrecioDia;
    
    @FXML
    private ComboBox boxEstado;
    
    @FXML
    private ComboBox boxDisponible;
    
    @FXML
    private Button bCancelar;
   
    
    public static void setRfc(String rfc){
        clienteRfc = rfc;
    }
    @FXML
       public void cargarPaginaEscogerPropietario() {
         Stage stage = new Stage();
         try {
             Parent root = FXMLLoader.load(getClass().getResource("PrincipalAutos.fxml"));
             Scene scene = new Scene(root);
   
     
             stage.setScene(scene);
             stage.show();
             closeButtonAction();
         } catch (IOException ex) { 
            Logger.getLogger(PEscogerPropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        } 
       }
    @FXML
        private void closeButtonAction(){
            // get a handle to the stage
            Stage stage = (Stage) boxDisponible.getScene().getWindow();
            // do what you have to do
             stage.close();
        }
    @FXML
    public void crearVehiculo(ActionEvent event) {
      
        motor = txtNoMotor.getText();
      
        String valueClima = boxClima.getValue().toString();
        switch(valueClima) {
            case "Si":
                clima = 1;
                break;
            case "No":
                clima = 2;
                break;
        }
         
        String valueTransmision = boxTransmision.getValue().toString();
        switch(valueTransmision) {
            case "Automatico":
                transmision = 2;
                break;
                
            case "Manual":
                transmision = 1;
                break;
        }
        
        noPasajeros = Integer.parseInt(txtNoPasajeros.getText());
        noPuertas = Integer.parseInt(txtNoPuertas.getText());
        marca = txtMarca.getText();
        modelo = txtModelo.getText();
        version = txtVersion.getText();
        kilometraje = Double.parseDouble(txtKilometraje.getText());
        kml = Double.parseDouble(txtKml.getText());
            
        String valueGps = boxGps.getValue().toString();
        switch (valueGps) {
            case "Si":
                gps= 1;
                break;
            case "No":
                gps = 2;
                break;
        }
        
        String valueEstado = boxEstado.getValue().toString();
        switch (valueEstado) {
            case "1":
                estado = 1;
                break;
            case "2":
                estado = 2;
                break;
            case "3":
                estado = 3;
                break;
            case "4":
                estado = 4;
                break;
        }
        
        String valueDisponible = boxDisponible.getValue().toString();
        switch (valueGps) {
            case "Si":
                disponible = 1;
                break;
            case "No":
                disponible = 2;
                break;
        }
        descripcion = txtDescripcion.getText();
        precioDia = Double.parseDouble(txtPrecioDia.getText());


        matriculaFlotilla = "XLP0001";

        Thumbnail = "mx/fei/images/default-logo.jpg";
        
        
        
        //Crear vehiculo
        vehiculo.setNoMotor(motor);
        vehiculo.setClimatizado(clima);
        vehiculo.setTransmision(transmision);
        vehiculo.setNumPasajeros(noPasajeros);
        vehiculo.setNumPuertas(noPuertas);
        vehiculo.setMarca(marca);
        vehiculo.setModelo(modelo);
        vehiculo.setVersion(version);
        vehiculo.setKilometraje(kilometraje);
        vehiculo.setKml(kml);
        vehiculo.setGps(gps);
        vehiculo.setDescripcion(descripcion);
        vehiculo.setEstado(estado);
        vehiculo.setDisponibilidad(disponible);
        vehiculo.setPrecioDia(precioDia);
        vehiculo.setThumbnail(Thumbnail);
        
        //Agregar vehiculo a la base
        VehiculoDAO vehiculoDao = new VehiculoDAO();
        
        vehiculoDao.agregarAuto(vehiculo, clienteRfc, matriculaFlotilla);
        closeButtonAction();
        cargarPaginaEscogerPropietario();
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boxClima.getItems().add("Si");
        boxClima.getItems().add("No");
        
        boxTransmision.getItems().add("Automatico");
        boxTransmision.getItems().add("Manual");
        
        boxGps.getItems().add("Si");
        boxGps.getItems().add("No");
        
        boxEstado.getItems().add("1");
        boxEstado.getItems().add("2");
        boxEstado.getItems().add("3");
        boxEstado.getItems().add("4");
        
        boxDisponible.getItems().add("Si");
        boxDisponible.getItems().add("No");
        
        
        
        txtNoMotor.setOnKeyTyped(event -> {
            int maxCaracter = 11;
            if(txtNoMotor.getText().length() > maxCaracter) event.consume();
        });
        
        txtNoPasajeros.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtNoPasajeros.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        txtNoPasajeros.setOnKeyTyped(event -> {
            int maxCaracter = 1;
            if(txtNoPasajeros.getText().length() > maxCaracter) event.consume();
        });
        
        txtNoPuertas.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtNoPuertas.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        txtNoPuertas.setOnKeyTyped(event -> {
            int maxCaracter = 0;
            if(txtNoPuertas.getText().length() > maxCaracter) event.consume();
        });
        
        txtMarca.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[A-z]")) {
                txtMarca.setText(newValue.replaceAll("[^A-z]", ""));
            }
        });
        
        txtMarca.setOnKeyTyped(event -> {
            int maxCaracter = 19;
            if(txtMarca.getText().length() > maxCaracter) event.consume();
        });
        
        txtModelo.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtModelo.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        txtModelo.setOnKeyTyped(event -> {
            int maxCaracter = 3;
            if(txtModelo.getText().length() > maxCaracter) event.consume();
        });
        
        txtVersion.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtModelo.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        txtModelo.setOnKeyTyped(event -> {
            int maxCaracter = 1;
            if(txtModelo.getText().length() > maxCaracter) event.consume();
        });
        
        txtModelo.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtModelo.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        txtModelo.setOnKeyTyped(event -> {
            int maxCaracter = 0;
            if(txtModelo.getText().length() > maxCaracter) event.consume();
        });
        
        txtKilometraje.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtKilometraje.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        txtKilometraje.setOnKeyTyped(event -> {
            int maxCaracter = 15;
            if(txtKilometraje.getText().length() > maxCaracter) event.consume();
        });
        
        txtModelo.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtModelo.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        txtModelo.setOnKeyTyped(event -> {
            int maxCaracter = 3;
            if(txtModelo.getText().length() > maxCaracter) event.consume();
        });
        
        txtModelo.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtModelo.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        txtPrecioDia.setOnKeyTyped(event -> {
            int maxCaracter = 2;
            if(txtPrecioDia.getText().length() > maxCaracter) event.consume();
        });
    }
}

  