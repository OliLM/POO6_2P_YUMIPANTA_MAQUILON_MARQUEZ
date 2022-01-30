/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class VentanaUbicacionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try(FileInputStream input =new FileInputStream(App.imagen+"ubicacion.png")){
            Image i=new Image(input);
            BackgroundImage bgI=new BackgroundImage(i, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT); 
            Background bg= new Background(bgI);
            root.setBackground(bg);
        }catch(Exception i){
            System.out.println("algo salio mal ya fue");
            
        }
    } 
    @FXML
    Pane root;
            
    
    
    
          
    
    
}
