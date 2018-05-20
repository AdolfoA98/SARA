/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import mx.fei.DAO.UsuarioDAO;
import mx.fei.domain.Usuario;


/**
 * FXML Controller class
 *
 * @author jethr
 */
public class PEscogerPropietarioController implements Initializable {
    private UsuarioDAO usuariodao = new UsuarioDAO();
    private List<Usuario> usuarios;
    private ObservableList<Usuario> observableUsuario;
    
    @FXML
    private ListView listaUsuarios;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        usuarios = usuariodao.ObtenerTodoslosCliente();
        observableUsuario = FXCollections.observableArrayList(usuarios);
        listaUsuarios.setItems(observableUsuario);
        
        inicializarCeldas();
    }
    
    private void inicializarCeldas(){
        listaUsuarios.setCellFactory(celdas -> new ListCell<Usuario>(){
            
            @Override
            protected void updateItem(Usuario usuario, boolean vacio){
                super.updateItem(usuario, vacio);
                if(vacio || usuario == null || usuario.getNombre() == null){
                    setText(null);
                }else{
                    setText(usuario.getNombre());
                }
            }
        });
    }
    
       @FXML
       public void cargarPaginaAgregarAuto() {
         Stage stage = new Stage();
         try {
             Parent root = FXMLLoader.load(getClass().getResource("PAgregarAuto.fxml"));
             Scene scene = new Scene(root);
             
             stage.setScene(scene);
             stage.show();
         } catch (IOException ex) {
             Logger.getLogger(PAgregarAuto.class.getName()).log(Level.SEVERE, null, ex);
         }
       }
    
}
