/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import mx.fei.domain.Vehiculo;

/**
 * FXML Controller class
 *
 * @author adolf
 */
public class RentaController implements Initializable {
    
    private static Vehiculo vehiculo;
    
    @FXML
    private StackPane stack;
    
    @FXML
    private TextField noTarjeta;
    
    @FXML
    private TextField cuatroDigitos;
    
    @FXML
    private TextField mesCaducidad;
    
    @FXML
    private TextField anioCaducidad;
    
    @FXML
    private TextField ccv;
    
    @FXML
    private ComboBox<Label> tipo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tipo.getItems().add(new Label("Visa"));
        tipo.getItems().add(new Label("Mastercard"));
    }

    public static void setInfo(Vehiculo auto){
        vehiculo = auto;
    }
    
    @FXML
    public void realizarRenta(){
        System.out.println(noTarjeta.getText());
        if("".equals(cuatroDigitos.getText()) && "".equals(mesCaducidad.getText()) && "".equals(anioCaducidad.getText()) && "".equals(ccv.getText()) && "".equals(noTarjeta.getText()) ){
            JFXDialog dialog = new JFXDialog();
            dialog.setPrefHeight(200);
            dialog.setContent(new Label("Hay campos vacíos que son importantes para la realización de la renta"
                                        + ". Introduzca la información correspondiente he inténtelo de nuevo. "));
            dialog.show(stack);
        }
    }
    
}
