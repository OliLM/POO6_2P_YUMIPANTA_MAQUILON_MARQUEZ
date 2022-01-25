/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import controladores.Principal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author ismael123
 */
public class Usuario  {
    private String usuario;
    private String paswword;
    private char tipo;

    public Usuario(String usuario, String paswword, char tipo) {
        this.usuario = usuario;
        this.paswword = paswword;
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPaswword() {
        return paswword;
    }

    public void setPaswword(String paswword) {
        this.paswword = paswword;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    public static char obtener_tipo(String user, String password , String ruta){
        char tipo ='x';
        try {
            FileReader reader= new FileReader(new File(ruta));
            BufferedReader bf= new BufferedReader(reader);
            String Encabezado=bf.readLine();
            String linea=null;
            while((linea=bf.readLine())!=null){
                String [] datos=linea.split(",");
                tipo=datos[2].charAt(0);    
            }            
        }catch(Exception e){     
        }
        return tipo;  
    }
    
    
    
}
