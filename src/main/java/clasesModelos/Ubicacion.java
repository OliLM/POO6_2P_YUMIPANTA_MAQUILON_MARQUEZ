/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesModelos;

import com.mycompany.proyecto2p.App;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Ubicacion {
    private String nombre;
        private double coordX;
        private double coordY;
        private String direccion;
        private String horario;

        public Ubicacion(String nombre, double coordX, double coordY, String direcion, String horario) {
            this.nombre = nombre;
            this.coordX = coordX;
            this.coordY = coordY;
            this.direccion = direccion;
            this.horario = horario;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getCoordX() {
            return coordX;
        }

        public void setCoordX(double coordX) {
            this.coordX = coordX;
        }

        public double getCoordY() {
            return coordY;
        }

        public void setCoordY(double coordY) {
            this.coordY = coordY;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getHorario() {
            return horario;
        }

        public void setHorario(String horario) {
            this.horario = horario;
        }

        @Override
        public String toString() {
            return "Ubicacion{" + "nombre=" + nombre + ", coordX=" + coordX + ", coordY=" + coordY + ", direccion=" + direccion + ", horario=" + horario + '}';
        }
        
        public static ArrayList<Ubicacion> cargarUbicacionesMapas() {
        ArrayList<Ubicacion> l_ubicaciones = new ArrayList<>();
        try {
            FileReader fr = new FileReader(new File(App.pathFiles + "sucursales.txt"), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr);

            String linea = null;
            while ((linea = br.readLine()) != null) {

                String[] datos_u = linea.split("-");
                Ubicacion ub = new Ubicacion(datos_u[0], Double.valueOf(datos_u[1]), Double.valueOf(datos_u[2]), datos_u[3], datos_u[4]);
                l_ubicaciones.add(ub);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return l_ubicaciones;
    }
}
