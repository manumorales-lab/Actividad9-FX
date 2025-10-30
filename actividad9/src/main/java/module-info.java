module co.edu.poli.actividad9 {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens co.edu.poli.actividad9 to javafx.fxml;
    exports co.edu.poli.actividad9;
    
    // Para acceder a tus clases del CRUD
    exports co.edu.poli.actividad5.model;
    exports co.edu.poli.actividad5.servicios;
    exports co.edu.poli.actividadd5.vista;
    exports co.edu.poli.vista;
}