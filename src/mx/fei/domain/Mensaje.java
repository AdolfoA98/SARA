/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.domain;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Mensaje{
    
    private Alert alerta;
    
    public Mensaje(){
    }
    
    public void setTipoMensaje(AlertType tipo){
        alerta = new Alert(tipo);
    }
    
    public void setTitulo(String titulo){
        alerta.setTitle(titulo);
    }
    
    public void setContenido(String contenido){
        alerta.setContentText(contenido);
    }
    
    public void setEncabezado(String encabezado){
        alerta.setHeaderText(encabezado);
    }
    
    public void mostrarMensaje(){
        alerta.showAndWait();
    }
}
