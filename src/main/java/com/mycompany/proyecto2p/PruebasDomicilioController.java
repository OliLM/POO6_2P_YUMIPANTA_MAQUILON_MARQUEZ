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
        // TODO
        ArrayList<String> tipo = new ArrayList<>();
        tipo.add("Diagnóstico");
        tipo.add("Anticuerpos");

        comboDiagnostico.getItems().addAll(tipo);
        
        comboDiagnostico.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                Platform.runLater(new Runnable() {
            @Override
            public void run() {
                comboPrueba.getItems().addAll(CargarCombo(comboDiagnostico.getValue()));
                }});
                
            }
            
        });
        
    }

    @FXML
    private VBox root;
    @FXML
    private ComboBox<String> comboDiagnostico;
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
