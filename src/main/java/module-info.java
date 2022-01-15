module com.poo.proyectopoo2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.poo.proyectopoo2 to javafx.fxml;
    exports controladores;
}
