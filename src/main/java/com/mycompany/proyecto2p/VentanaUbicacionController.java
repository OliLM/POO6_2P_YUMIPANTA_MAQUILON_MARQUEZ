/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import clasesModelos.Ubicacion;
import javafx.application.Platform;

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
        try (FileInputStream input = new FileInputStream(App.imagen + "ubicacion.PNG")) {
            Image i = new Image(input);
            BackgroundImage bgI = new BackgroundImage(i, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background bg = new Background(bgI);
            root.setBackground(bg);
        } catch (Exception i) {
            System.out.println("algo salio mal ya fue");
            cargarFicherosMapa(Ubicacion.cargarUbicacionesMapas());
        }

        cargarFicherosMapa(Ubicacion.cargarUbicacionesMapas());

    }

    public void cargarFicherosMapa(ArrayList<Ubicacion> l_u) {

        for (Ubicacion u : l_u) {
            int numero_a = (int) (Math.floor(Math.random() * (10)) + 1);
            Thread Hpu = new Thread(new Runnable() {
                @Override
                public void run() {
                    try (FileInputStream img = new FileInputStream(App.imagen + "ficha.jpg")) {
                        Thread.sleep(1000 * numero_a);
                        Image imf = new Image(img);
                        ImageView imgv = new ImageView(imf);
                        imgv.setFitHeight(100);
                        imgv.setPreserveRatio(true);
                        Platform.runLater(() -> {
                           
                            root.getChildren().add(imgv);
                            imgv.setLayoutX(u.getCoordX());
                            imgv.setLayoutY(u.getCoordY());
                            

                        });

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            });
            Hpu.start();

        }
    }

    void mostrarInfoFiche(ImageView a) {

    }

    @FXML
    Pane root;

    public void ubicaciones() {
        try (BufferedReader bf = new BufferedReader(new FileReader(App.pathFiles + "Sucursales.txt"))) {
//            String linean =
        } catch (IOException e) {

        }

    }

}
