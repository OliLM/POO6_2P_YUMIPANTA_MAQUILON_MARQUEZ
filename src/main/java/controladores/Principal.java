/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ismael123
 */
public class Principal extends Application {

    @Override
    public void start(Stage S_inicio) throws Exception {
       FXMLLoader  fxmloader= new FXMLLoader(Principal.class.getResource("Loggin.fxml")) ; 
      Parent root_loggin=fxmloader.load();
      Scene inicio= new Scene(root_loggin,640,480);
     
      
      
        
        
        
        
    }
    
}
