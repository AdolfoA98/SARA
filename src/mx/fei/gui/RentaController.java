/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import com.jfoenix.controls.JFXDialogLayout;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import mx.fei.domain.Vehiculo;

/**
 * FXML Controller class
 *
 * @author adolf
 */
public class RentaController implements Initializable {
    
    private static Vehiculo vehiculo;
    
    public static void setInfo(Vehiculo auto){
        vehiculo = auto;
    }
    
    private JFXDialog dialog;
    private JFXDialogLayout dialogLayout;
    
    @FXML
    private StackPane stack;
    
    @FXML
    private TextField noTarjeta;
    
    @FXML
    private TextField cuatroDigitos;
    
    @FXML
    private ComboBox<Label> mesCaducidad;
    
    @FXML
    private ComboBox<Label> anioCaducidad;
    
    @FXML
    private TextField ccv;
    
    @FXML
    private ComboBox<Label> tipo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mesCaducidad.getItems().add(new Label("01"));
        mesCaducidad.getItems().add(new Label("02"));
        mesCaducidad.getItems().add(new Label("03"));
        mesCaducidad.getItems().add(new Label("04"));
        mesCaducidad.getItems().add(new Label("05"));
        mesCaducidad.getItems().add(new Label("06"));
        mesCaducidad.getItems().add(new Label("07"));
        mesCaducidad.getItems().add(new Label("08"));
        mesCaducidad.getItems().add(new Label("09"));
        mesCaducidad.getItems().add(new Label("10"));
        mesCaducidad.getItems().add(new Label("11"));
        mesCaducidad.getItems().add(new Label("12"));
        
        anioCaducidad.getItems().add(new Label("2019"));
        anioCaducidad.getItems().add(new Label("2020"));
        anioCaducidad.getItems().add(new Label("2021"));
        anioCaducidad.getItems().add(new Label("2022"));
        anioCaducidad.getItems().add(new Label("2023"));
        
        tipo.getItems().add(new Label("Visa"));
        tipo.getItems().add(new Label("Mastercard"));
    }

    
    @FXML
    public void realizarRenta(){
        if("".equals(cuatroDigitos.getText())|| "".equals(ccv.getText()) || "".equals(noTarjeta.getText()) ){
            Mensaje mensaje = new Mensaje();
            mensaje.setHeader("Datos faltantes");
            mensaje.setBody("Parece que hay campos vacíos que son necesarios para realizar la renta."
                                + " Sin esta información no podremos realizarla transacción de manera exitosa."
                                + " Introduzca los datos e inténtelo nuevamente");
            dialog = new JFXDialog(stack, mensaje, DialogTransition.CENTER);
            mensaje.setDialog(dialog);
            dialog.show(stack);
        }
    }
    
}
