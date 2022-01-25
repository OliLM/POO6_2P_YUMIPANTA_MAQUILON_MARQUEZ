module com.poo.proyectopoo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.poo.proyectopoo2 to javafx.fxml;
    exports controladores;
}
