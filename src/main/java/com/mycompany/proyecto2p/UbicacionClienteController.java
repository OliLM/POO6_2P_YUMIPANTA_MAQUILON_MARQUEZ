/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2p;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class UbicacionClienteController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private Pane pane;
    @FXML
    private TextField textDireccion;
    @FXML
    private TextField textFecha;
    @FXML
    private TextField textHora;
    @FXML
    private Button btnFinalizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try(FileInputStream input =new FileInputStream(App.imagen+"ubicacion.png")){
            Image i=new Image(input);
            BackgroundImage bgI=new BackgroundImage(i, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT); 
            Background bg= new Background(bgI);
            pane.setBackground(bg);
        }catch(Exception i){
            System.out.println("algo salio mal ya fue");
            
        }
        
    }    

    @FXML
    private void guardarInformacion(ActionEvent event) {
        

    }
    
}
