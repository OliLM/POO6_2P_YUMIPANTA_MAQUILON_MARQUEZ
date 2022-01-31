/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2p;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import clasesModelos.Prueba;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import clasesModelos.Prueba;
import java.util.ArrayList;
/**
 * FXML Controller class
 *
 * @author DELL
 */
public class PruebasDomicilioController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private VBox root;
    @FXML
    private ComboBox<String> ComboTipo;
    @FXML
    private ComboBox<Prueba> comboPrueba;
    @FXML
    private TextField texCantidad;
    @FXML
    private Button btnAgregar;
    @FXML
    private VBox nombreProductos;
    @FXML
    private Label textNombre;
    @FXML
    private VBox cantidadProductos;
    @FXML
    private Label textCantidad;
    @FXML
    private VBox precioProductos;
    @FXML
    private Label textPrecio;
    @FXML
    private Label subTotal;
    @FXML
    private Label servicioDomicilio;
    @FXML
    private Label total;
    @FXML
    private Button btnContinuar;
    @FXML 
    private Label dinero;
    @FXML
    void ValorPrueba(ActionEvent e){
        Prueba p=comboPrueba.getValue();
        double valor=p.getPrecio();
        dinero.setText(String.valueOf(valor));
    }
    void AgregarPruebas(){
        
    }
    
    
    
    
  
  
}

 
  
  
  


    
    

