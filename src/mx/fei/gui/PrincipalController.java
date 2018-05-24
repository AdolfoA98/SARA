/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.layout.StackPane;
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
    private StackPane stack;
    
    @FXML
    private JFXDatePicker fechaRecogida;
    
    @FXML
    private JFXTimePicker horaRecogida;
    
    @FXML
    private JFXDatePicker fechaDevolucion;
    
    @FXML
    private JFXTimePicker horaDevolucion;


    @FXML
    private ImageView slider;
    
    @FXML
    private JFXComboBox<Label> flotillas;
    
    @FXML
    private JFXButton botonBuscar;
    
    private Slider sliderController;
    private boolean runSlider;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        runSlider = true;
        sliderController = new Slider();
        sliderController.start();
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
        int diasARentar = calcularDias();
        if(diasARentar > 0){
            runSlider = false;
            Stage actualStage = (Stage) botonBuscar.getScene().getWindow();
            Stage stage = new Stage();
            try {
                
                Parent root = FXMLLoader.load(getClass().getResource("PrincipalAutos.fxml"));
            
                Scene scene = new Scene(root);
                
                PrincipalAutosController.setDiasARentar(diasARentar);
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
        }else{
            Mensaje alerta = new Mensaje();
            alerta.setHeader("Fecha inválida");
            alerta.setBody("Las fechas introducidas no son válidas. Verifíquelas y vuelva a intentarlo");
            JFXDialog dialog = new JFXDialog(stack, alerta, DialogTransition.TOP);
            alerta.setDialog(dialog);
            dialog.show();
        }
    }
    
    
    
    private int calcularDias(){
        int diasARentar = 0;
        
        LocalDate fechaR = fechaRecogida.getValue();
        LocalDate fechaD = fechaDevolucion.getValue();
        
        if(fechaR == null || fechaD == null){
            return diasARentar;
        }
        
        int anioInicio = fechaR.getYear();
        int anioFin = fechaD.getYear();
        int diaInicio = fechaR.getDayOfYear();
        int diaFin = fechaD.getDayOfYear();
        
        if(anioInicio < anioFin){
            diasARentar = 365 - diaInicio;
            for(int i = anioInicio; i < anioFin; i++){
                diasARentar += 365;
            }
            diasARentar+=diaFin;
        }else if(anioInicio < LocalDate.now().getYear() || (diaInicio < LocalDate.now().getDayOfYear() && anioInicio == LocalDate.now().getYear())){
            diasARentar = -1;
        }else{
            diasARentar = diaFin - diaInicio;
        }
        
        return diasARentar;
    }

    private class Slider extends Thread {

        @Override
        public void run(){
            
            String[] imagenes = new String[3];
            imagenes[0] = "mx/fei/images/car-star.jpg";
            imagenes[1] = "mx/fei/images/slider2.jpg";
            imagenes[2] = "mx/fei/images/slider3.jpg";
            
            int contador = 0;
            
            while(runSlider){
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
