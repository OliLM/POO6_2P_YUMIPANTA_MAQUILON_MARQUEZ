/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2p;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class App extends Application{
    private static Scene scene;
    public static String imagen="src/main/resources/imagenes/";
    public static String pathFiles="src/main/resources/files/";
    
    @Override
    public void start(Stage s) throws IOException{
        FXMLLoader fx = new FXMLLoader(App.class.getResource("VentanaInicio.fxml"));
        Parent root = fx.load();
        scene = new Scene(root);
        s.setScene(scene);
        s.setTitle("Vithas Labs");
        s.show();
        
        
    }
    
    public static void main(String[] args) {
        launch();
    }
}
