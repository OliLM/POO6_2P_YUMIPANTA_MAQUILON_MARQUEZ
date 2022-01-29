/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class VentanaInicioController implements Initializable {

    @FXML
    private Button btnenviar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        crearcuenta.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                crearUsuario();

            }

        });
    }
    @FXML
    private VBox rootPrincipal;
    @FXML
    private ImageView imagenPortada;
    @FXML
    private Label error;
    @FXML
    private HBox hbU;
    @FXML
    private HBox hbC;
    @FXML
    private Label crearcuenta;

    @FXML
    private void ventanaUsuario(ActionEvent event) {
        //validar usuario
            
        
        //Codigo para el contenedor de Label Bienvenido
        Label nombrePaciente = new Label("Bienvenido");
        nombrePaciente.setFont(Font.font(20));
        nombrePaciente.setTextFill(Paint.valueOf("White"));
        VBox h1 = new VBox();
        h1.setAlignment(Pos.TOP_LEFT);
        h1.getChildren().add(nombrePaciente);
        h1.setPadding(new Insets(30, 0, 60, 20));

        //Codigo para los botones y su contenedor
        //btn1
        Button btnUbicaciones = new Button();
        btnUbicaciones.setText("Conoce nuestras Ubicaciones");
        btnUbicaciones.setStyle("-fx-background-color:Blue");
        btnUbicaciones.setTextFill(Paint.valueOf("White"));

        //btn2
        Button btnDomicilio = new Button();
        btnDomicilio.setText("Solicitar pruebas a domicilio");
        btnDomicilio.setStyle("-fx-background-color:Blue");
        btnDomicilio.setTextFill(Paint.valueOf("White"));

        //contenedor
        VBox contenedorBotones = new VBox();
        contenedorBotones.getChildren().addAll(btnUbicaciones, btnDomicilio);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setSpacing(40);

        //contenedor Principal
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(30);
        root.getChildren().addAll(h1, contenedorBotones);
     
        try(FileInputStream input =new FileInputStream(App.imagen+"fondo.jpg")){
            Image i=new Image(input);
            BackgroundImage bgI=new BackgroundImage(i, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT); 
            Background bg= new Background(bgI);
            root.setBackground(bg);
        }catch(Exception i){
            System.out.println("algo salio mal ya fue");
            
        }

        //ventada Usuario
        Stage s = (Stage) btnenviar.getScene().getWindow();
        Scene c = new Scene(root, 600, 400);
        s.setScene(c);
        s.show();

        //controlador de evento para el boton ubicaciones
        btnUbicaciones.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //Validar Usuario
                
                
                
                //Ventana Ubicaciones
                Stage stage = new Stage();
                FXMLLoader fx = new FXMLLoader(App.class.getResource("VentanaUbicacion.fxml"));
                try {
                    Parent root = fx.load();
                    Scene scene = new Scene(root,1200,800);
                    stage.setScene(scene);
                    stage.setTitle("Ubicaciones");
                    stage.show();
                } catch (IOException ex) {

                }

            }

        });
        
        
        //**************Ventana pruebas a domicilio************
        
        btnDomicilio.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                Stage s = new Stage();
                FXMLLoader fx = new FXMLLoader(VentanaInicioController.class.getResource("PruebasDomicilio.fxml"));
                try{
                    Parent root = fx.load();
                    Scene sc = new Scene(root);
                    s.setScene(sc);
                    s.setTitle("Pruebas a domicilio");
                    s.show();
                    
                    
                }catch(IOException ex){
                    
                }
                
            }
        
        
        });
        

    }
    
    
    

    public void crearUsuario() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                //root
                VBox root = new VBox();

                Label titulo = new Label("Nuevo Paciente");
                titulo.setFont(Font.font(20));
                titulo.setTextFill(Paint.valueOf("BLUE"));
                HBox contTitulo = new HBox();
                contTitulo.getChildren().add(titulo);
                contTitulo.setAlignment(Pos.CENTER);

                //primer GridPane y estructura
                GridPane grid1 = new GridPane();

                Label cedula = new Label("Cedula:");
                HBox hCedula = new HBox();
                hCedula.getChildren().add(cedula);
                hCedula.setAlignment(Pos.CENTER_RIGHT);
                hCedula.setPadding(new Insets(0, 10, 0, 0));
                TextField datoCedula = new TextField();
                grid1.add(hCedula, 0, 0);
                grid1.add(datoCedula, 1, 0);

                Label nombres = new Label("Nombres:");
                HBox hNombre = new HBox();
                hNombre.getChildren().add(nombres);
                hNombre.setAlignment(Pos.CENTER_RIGHT);
                hNombre.setPadding(new Insets(0, 10, 0, 0));
                TextField datoNombres = new TextField();
                grid1.add(hNombre, 0, 1);
                grid1.add(datoNombres, 1, 1);

                Label apellidos = new Label("Apellidos:");
                HBox hApellido = new HBox();
                hApellido.getChildren().add(apellidos);
                hApellido.setAlignment(Pos.CENTER_RIGHT);
                hApellido.setPadding(new Insets(0, 10, 0, 0));
                TextField datoApellidos = new TextField();
                grid1.add(hApellido, 0, 2);
                grid1.add(datoApellidos, 1, 2);

                Label fechaNacimiento = new Label("Fecha de Nacimiento:");
                HBox hFecha = new HBox();
                hFecha.getChildren().add(fechaNacimiento);
                hFecha.setAlignment(Pos.CENTER_RIGHT);
                hFecha.setPadding(new Insets(0, 10, 0, 0));
                TextField datoFecha = new TextField();
                grid1.add(hFecha, 0, 3);
                grid1.add(datoFecha, 1, 3);

                grid1.setAlignment(Pos.CENTER);
                grid1.setVgap(10);
                grid1.setHgap(10);

                //RadioButtons
                ToggleGroup grupo = new ToggleGroup();
                Label genero = new Label("Genero:");
                HBox hGenero = new HBox();
                hGenero.getChildren().add(genero);
                hGenero.setAlignment(Pos.CENTER_RIGHT);
                hGenero.setPadding(new Insets(0, 10, 0, 0));
                HBox hboxButtons = new HBox();
                RadioButton rb1 = new RadioButton();
                rb1.setText("Masculino");
                rb1.setToggleGroup(grupo);
                RadioButton rb2 = new RadioButton();
                rb2.setText("Femenino");
                rb2.setToggleGroup(grupo);
                RadioButton rb3 = new RadioButton();
                rb3.setText("Otros");
                rb3.setToggleGroup(grupo);
                hboxButtons.getChildren().addAll(rb1, rb2, rb3);
                hboxButtons.setSpacing(10);
                grid1.add(hGenero, 0, 4);
                grid1.add(hboxButtons, 1, 4);

                //Segunda Parte
                Label ciudad = new Label("Ciudad:");
                HBox hCiudad = new HBox();
                hCiudad.getChildren().add(ciudad);
                hCiudad.setAlignment(Pos.CENTER_RIGHT);
                hCiudad.setPadding(new Insets(0, 10, 0, 0));
                TextField datoCiudad = new TextField();
                grid1.add(hCiudad, 0, 5);
                grid1.add(datoCiudad, 1, 5);

                Label email = new Label("Email:");
                HBox hEmail = new HBox();
                hEmail.getChildren().add(email);
                hEmail.setAlignment(Pos.CENTER_RIGHT);
                hEmail.setPadding(new Insets(0, 10, 0, 0));
                TextField datoEmail = new TextField();
                grid1.add(hEmail, 0, 6);
                grid1.add(datoEmail, 1, 6);

                Label telefono = new Label("Teléfono:");
                HBox hTelefono = new HBox();
                hTelefono.getChildren().add(telefono);
                hTelefono.setAlignment(Pos.CENTER_RIGHT);
                hTelefono.setPadding(new Insets(0, 10, 0, 0));
                TextField datoTelefono = new TextField();
                grid1.add(hTelefono, 0, 7);
                grid1.add(datoTelefono, 1, 7);

                Label usuario = new Label("Usuario:");
                HBox hUsuario = new HBox();
                hUsuario.getChildren().add(usuario);
                hUsuario.setAlignment(Pos.CENTER_RIGHT);
                hUsuario.setPadding(new Insets(0, 10, 0, 0));
                TextField datoUsuario = new TextField();
                grid1.add(hUsuario, 0, 8);
                grid1.add(datoUsuario, 1, 8);

                Label contrasena = new Label("Contraseña:");
                HBox hContrasena = new HBox();
                hContrasena.getChildren().add(contrasena);
                hContrasena.setAlignment(Pos.CENTER_RIGHT);
                hContrasena.setPadding(new Insets(0, 10, 0, 0));
                TextField datoContrasena = new TextField();
                grid1.add(hContrasena, 0, 9);
                grid1.add(datoContrasena, 1, 9);

                Button registrar = new Button();
                registrar.setText("Registrar");
                registrar.setStyle("-fx-background-color:Blue");
                HBox hRegistro = new HBox();
                hRegistro.getChildren().add(registrar);
                hRegistro.setAlignment(Pos.CENTER);

                Label mensaje = new Label("");
                HBox hMensaje = new HBox();
                hMensaje.getChildren().add(mensaje);
                hMensaje.setAlignment(Pos.CENTER);

                //Nueva Ventana
                Stage nuevoPaciente = (Stage) crearcuenta.getScene().getWindow();
                root.setSpacing(20);
                root.getChildren().addAll(contTitulo, grid1);
                Scene scene = new Scene(root, 600, 500);
                nuevoPaciente.setScene(scene);
                nuevoPaciente.setTitle("Nuevo Paciente");
                root.getChildren().addAll(hRegistro, hMensaje);

                registrar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        String genero="";
                        String dcedula="";
                        String dnombre="";
                        String dapellido = "";
                        String dfecha = "";
                        String dciudad ="";
                        String demail = "";
                        String dtelefono = "";
                        String dusuario = "";
                        String dcontrasena ="";
                        
                        try{
                        RadioButton elegido = (RadioButton) grupo.getSelectedToggle();
                         dcedula = datoCedula.getText();
                         dnombre = datoNombres.getText();
                         dapellido = datoApellidos.getText();
                         dfecha = datoFecha.getText();
                         dciudad = datoCiudad.getText();
                         demail = datoEmail.getText();
                         dtelefono = datoTelefono.getText();
                         dusuario = datoUsuario.getText();
                         dcontrasena = datoContrasena.getText();
                         genero=elegido.getText();//Debe ser seleccionado    
                        }catch(RuntimeException a){
                               
                            }
                        if (
                                  ("".equals(dcedula)) || ("".equals(dnombre)) ||
                                  ("".equals(dapellido)) || (" ".equals(dfecha)) ||
                                  ("".equals(dciudad)) || (" ".equals(demail)) ||
                                  ("".equals(dtelefono)) || (" ".equals(dusuario)) ||
                                  ("".equals(dcontrasena)|| "".equals(genero))
                                 ) {
                             mensaje.setText("Hay campos vacios");
                            mensaje.setTextFill(Paint.valueOf("Red"));
                           
                        } else {
                            try (BufferedWriter bf = new BufferedWriter(new FileWriter(App.pathFiles + "usuarios.txt", true))) {
                                String linea = datoUsuario.getText() + "," + datoContrasena.getText() + "," + "P\n";
                                bf.write(linea);

                                try (BufferedWriter b = new BufferedWriter(new FileWriter(App.pathFiles + "pacientes.txt", true))) {
                                    String linea2 = datoUsuario.getText() + "," + datoCedula.getText() + "," + datoNombres.getText() + "," + datoApellidos.getText() + "," + datoFecha.getText()
                                            + "," + genero + "," + datoCiudad.getText() + "," + datoEmail.getText() + "," + datoTelefono.getText();
                                    b.write(linea2 + "\n");
                                    mensaje.setText("Su registro fue exitoso");

                                } catch (IOException ex) {

                                }

                            } catch (IOException ex) {
                                System.out.println("no se encontro");
                            }
                        }
                       
                    }

                });

                nuevoPaciente.show();

            }
        });

    }

}
