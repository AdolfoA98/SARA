/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;

import mx.fei.DAO.VehiculoDAO;
import mx.fei.domain.Vehiculo;

/**
 * FXML Controller class
 *
 * @author jethr
 */
public class PAgregarAuto {
    
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
    private int disponibilidad;
    private String matriculaFlotilla;
    private double precioDia;
    private String Thumbnail;
    private static String clienteRfc;
    private String matriculaAdmi;

    @FXML
    private TextField txtNoMotor;
    
    @FXML
    private ToggleGroup toggleGroup1;
    
    @FXML
    private ToggleGroup toggleGroup2;
    
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
    private ToggleGroup toggleGroup3;
    
    @FXML
    private TextArea txtDescripcion;
    
    @FXML
    private TextField txtPrecioDia;
    
    @FXML
    private ToggleGroup toggleGroup4;
    
    @FXML
    private ToggleGroup toggleGroup5;
    
   
    
    public static void setRfc(String rfc){
        clienteRfc = rfc;
    }
    
    @FXML
    public void crearVehiculo(ActionEvent event) {
      
        motor = txtNoMotor.getText();
        
        if(toggleGroup1.getSelectedToggle() != null) {
            switch(toggleGroup1.getSelectedToggle().getUserData().toString()) {
                case "No": 
                    clima = 2;
                    break;
                case "Si": 
                    clima = 1;
                    break; 
            }
        }
        
         if(toggleGroup2.getSelectedToggle() != null) {
            switch(toggleGroup2.getSelectedToggle().getUserData().toString()) {
                case "Automatico": 
                    transmision = 2 ;
                    break;
                case "Si": 
                    transmision = 1;
                    break; 
            }
        }
         
        noPasajeros = Integer.parseInt(txtNoPasajeros.getText());
        noPuertas = Integer.parseInt(txtNoPuertas.getText());
        marca = txtMarca.getText();
        modelo = txtModelo.getText();
        version = txtVersion.getText();
        kilometraje = Double.parseDouble(txtKilometraje.getText());
        kml = Double.parseDouble(txtKml.getText());
        
        if(toggleGroup3.getSelectedToggle() != null) {
            switch(toggleGroup3.getSelectedToggle().getUserData().toString()) {
                case "No": 
                    gps = 2;
                    break;
                case "Si": 
                    gps = 1;
                    break; 
            }
        }
        
        descripcion = txtDescripcion.getText();
        precioDia = Double.parseDouble(txtPrecioDia.getText());

        if(toggleGroup4.getSelectedToggle() != null) {
            switch(toggleGroup4.getSelectedToggle().getUserData().toString()) {
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
        }
        
        if(toggleGroup5.getSelectedToggle() != null) {
            switch(toggleGroup5.getSelectedToggle().getUserData().toString()) {
                case "No": 
                    disponibilidad = 2;
                    break;
                case "Si": 
                    disponibilidad = 1;
                    break; 
            }
        }
        
        
        matriculaFlotilla = "XLP0001";

        Thumbnail = "imagen";
        
        matriculaAdmi = "jose080698'";
        
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
        vehiculo.setDisponibilidad(disponibilidad);
        vehiculo.setPrecioDia(precioDia);
        vehiculo.setThumbnail(Thumbnail);
        
        //Agregar vehiculo a la base
        VehiculoDAO vehiculoDao = new VehiculoDAO();
        
        vehiculoDao.agregarAuto(vehiculo, clienteRfc, matriculaFlotilla, matriculaAdmi);
        
    }
}

  