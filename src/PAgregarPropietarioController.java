/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mx.fei.DAO.UsuarioDAO;
import mx.fei.domain.Usuario;

/**
 * FXML Controller class
 *
 * @author jethr
 */
public class PAgregarPropietarioController implements Initializable {
    
    Usuario usuario = new Usuario();
    
    private String rfc;
    private String nombre;
    private String apellidos;
    private String municipio;
    private String estado;
    private String calleDireccion;
    private String colDireccion;
    private int noDireccion;
    private String codigoPostal;
    private String email;
    private String telefono;
    private String contrasena;
    
    @FXML 
    private Button Bagregar;
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    private TextField txtRfc;
    
    @FXML
    private TextField txtNombre;
    
    @FXML
    private TextField txtApellidos;
    
    @FXML
    private TextField txtMunicipio;
    
    @FXML
    private TextField txtEstado;
    
    @FXML
    private TextField txtCalleDir;
    
    @FXML
    private TextField txtColDir;
    
    @FXML
    private TextField txtNoDireccion;
    
    @FXML
    private TextField txtCodigoPostal;
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtTelefono;
    
    @FXML
    private TextField txtContrasena;
    
    @FXML
    private Button bCancelar;
    
    
    /**
     * Initializes the controller class.
     */
    @FXML
       public void cargarPaginaEscogerPropietario() {
         Stage stage = new Stage();
         try {
             Parent root = FXMLLoader.load(getClass().getResource("PEscogerPropietario.fxml"));
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
            Stage stage = (Stage) txtContrasena.getScene().getWindow();
            // do what you have to do
             stage.close();
        }
   
    
    @FXML
    public void agregarPropietario() {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        rfc = txtRfc.getText();
        System.out.println(rfc);
        nombre = txtNombre.getText();
        System.out.println(nombre);
        apellidos = txtApellidos.getText();
        System.out.println(apellidos);
        municipio = txtMunicipio.getText();
        System.out.println(municipio);
        estado = txtEstado.getText();
        System.out.println(estado);
        calleDireccion = txtCalleDir.getText();
        System.out.println(calleDireccion);
        colDireccion = txtColDir.getText();
        System.out.println(colDireccion);
        noDireccion = Integer.parseInt(txtNoDireccion.getText());
        System.out.println(noDireccion);
        codigoPostal = txtCodigoPostal.getText();
        System.out.println(codigoPostal);
        email = txtEmail.getText();
           System.out.println(email);
        telefono = txtTelefono.getText();
        System.out.println(telefono);
        contrasena = txtContrasena.getText();
        System.out.println(contrasena);
        
        usuario.setRfc(rfc);
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setMunicipio(municipio);
        usuario.setEstado(estado);
        usuario.setCalleDireccion(calleDireccion);
        usuario.setColDireccion(colDireccion);
        usuario.setNumDireccion(noDireccion);
        usuario.setCodigoPostal(codigoPostal);
        usuario.setEmail(email);
        usuario.setTelefono(telefono);
        usuario.setContrasena(contrasena);
        
        usuarioDao.agregarCliente(usuario);
         cargarPaginaEscogerPropietario();
        closeButtonAction();
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         txtRfc.setOnKeyTyped(event -> {
            int maxCaracter = 12;
            if(txtRfc.getText().length() > maxCaracter) event.consume();
        });
        
        txtNombre.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[A-z]")) {
                txtNombre.setText(newValue.replaceAll("[^A-z]", ""));
            }
        });
        
        
        txtNombre.setOnKeyTyped(event -> {
            int maxCaracter = 40;
            if(txtNombre.getText().length() > maxCaracter) event.consume();
        });
        
        txtApellidos.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[A-z]")) {
                txtApellidos.setText(newValue.replaceAll("[^A-z]", ""));
            }
        });
        
        
        txtApellidos.setOnKeyTyped(event -> {
            int maxCaracter = 40;
            if(txtApellidos.getText().length() > maxCaracter) event.consume();
        });
        
        txtEstado.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[A-z]")) {
                txtEstado.setText(newValue.replaceAll("[^A-z]", ""));
            }
        });
        
        
        txtEstado.setOnKeyTyped(event -> {
            int maxCaracter = 20;
            if(txtEstado.getText().length() > maxCaracter) event.consume();
        });
        
        
        
        
        txtCalleDir.setOnKeyTyped(event -> {
            int maxCaracter = 40;
            if(txtCalleDir.getText().length() > maxCaracter) event.consume();
        });
        
        
        
        
        txtColDir.setOnKeyTyped(event -> {
            int maxCaracter = 40;
            if(txtColDir.getText().length() > maxCaracter) event.consume();
        });
        
        txtNoDireccion.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtNoDireccion.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        
        txtNoDireccion.setOnKeyTyped(event -> {
            int maxCaracter = 4;
            if(txtNoDireccion.getText().length() > maxCaracter) event.consume();
        });
        
        txtCodigoPostal.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtCodigoPostal.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        
        txtCodigoPostal.setOnKeyTyped(event -> {
            int maxCaracter = 4;
            if(txtCodigoPostal.getText().length() > maxCaracter) event.consume();
        });
        
        txtTelefono.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
            if(!newValue.matches("[0-9]")) {
                txtTelefono.setText(newValue.replaceAll("[^0-9]", ""));
            }
        });
        
        
        txtTelefono.setOnKeyTyped(event -> {
            int maxCaracter = 9;
            if(txtTelefono.getText().length() > maxCaracter) event.consume();
        });
        
    }    
    
}
