/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import Clases.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
/**
 *
 * @author ismael123
 */
public class LogginController {
    @FXML
    TextField txt_usuario;
    
    @FXML
    TextField txt_paswword;
    
    @FXML
    Button Button_iniciar;
    
    @FXML
    Hyperlink Hyperlink_nueva;
    
 
  void Iniciar(ActionEvent e){
     boolean v= Principal.IngresoSistema(txt_usuario.getText(),txt_paswword.getText(),Principal.docs+"usuarios.txt");
     if(v==true){
        char tipo=Usuario.obtener_tipo(txt_usuario.getText(), txt_paswword.getText(),Principal.docs+"usuarios.txt");
         Usuario usr=new Usuario(txt_usuario.getText(),txt_paswword.getText(),tipo);
         //falta sber si serializar o no el objeto
         FXMLLoader load= new FXMLLoader();
         try{
             Parent menu_opc_clientes= load.load(Principal.class.getResource("Clientes.fxml"));
             Scene clientes= new Scene(menu_opc_clientes,640,500);
             Parent loggin=Button_iniciar.getScene().getRoot();
            
             
             
         }catch(Exception u){
             
         }
         
         
           
     }else{
         Alert alerta= new Alert(Alert.AlertType.INFORMATION);
         alerta.setTitle("!!Aviso!!");
         alerta.setHeaderText("Usario o contraseña incorrectos");
         alerta.setContentText("Escribe bien chcno escroibas webadas :v");
      
  }
     
      
      
      
  }
    
}
