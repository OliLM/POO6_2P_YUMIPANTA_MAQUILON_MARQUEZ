/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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
    }    

    @FXML
    private VBox root;
    @FXML
    private ComboBox<?> comboDiagnostico;
    @FXML
    private ComboBox<?> comboPrueba;
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

    
    
}
