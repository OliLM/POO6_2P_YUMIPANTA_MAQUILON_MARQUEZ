/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2p;

import clasesModelos.Prueba;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;


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
       
        ArrayList<String> tipo = new ArrayList<>();
        tipo.add("Diagnóstico");
        tipo.add("Anticuerpos");

        ComboDiagnostico.getItems().addAll(tipo); 
    } 
    @FXML
   private  VBox vbox_nombre ;
   @FXML
   private VBox vbox_cantidad;
   @FXML
   private VBox vbox_Precio;
   
    

    @FXML
    private VBox root;
    @FXML
    private ComboBox<String> ComboDiagnostico;

    @FXML
    private ComboBox<Prueba> ComboPrueba;
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
   private void ValorPrueba(ActionEvent e){
        Prueba p=ComboPrueba.getValue();
        double valor=p.getPrecio();
        dinero.setText(String.valueOf(valor));
    }
    @FXML
   private void AgregarPruebas(ActionEvent o){
       double st=0;
        Label nombre=new Label(textNombre.getText()); 
        Label Cantidad=new Label(texCantidad.getText()); 
        Label Precio=new Label(textPrecio.getText()); 
        cantidadProductos.getChildren().add(Cantidad);
        nombreProductos.getChildren().add(nombre);
        precioProductos.getChildren().add(Precio);    
        double precio= Double.valueOf(textPrecio.getText());
        int cantidad= Integer.valueOf(texCantidad.getText());
        st+=precio*cantidad;
        double Total=st+5;
        vbox_nombre.getChildren().add(nombre);
        vbox_cantidad.getChildren().add(Cantidad);
        vbox_Precio.getChildren().add(Precio);
        subTotal.setText(String.valueOf(st));
        total.setText(String.valueOf(Total));  
    }
    
    private ArrayList<Prueba> CargarCombo(String tipo) {
        
        
        ArrayList<Prueba> pruebas = null;
        try {
            FileReader fr = new FileReader(new File(App.pathFiles + "pruebas.txt"),StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr);

            String linea = null;
            while ((linea = br.readLine()) != null) {
                
                String[] datos = linea.split(",");
                if (tipo.equals(datos[1])) {
                    
                    Prueba pb = new Prueba(datos[0], datos[1], datos[2], Double.valueOf(datos[3]));
                    
                    pruebas.add(pb);
                }

            }

        } catch (Exception a) {
            

        }
        return pruebas;

    }
    

    @FXML
    private void abrirVentanaUbicacionCliente(ActionEvent event) {
        Stage stage = (Stage) btnContinuar.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(App.class.getResource("UbicacionCliente.fxml"));
        try {
            Parent root = fx.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Vithas Labs");
            stage.show();
        } catch (IOException ex) {

        }

    }


}

 
  
  
  


    
    

