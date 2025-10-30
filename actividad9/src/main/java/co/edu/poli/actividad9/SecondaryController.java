package co.edu.poli.actividad9;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        cargarVentana("primary", 800, 500, "Menú Principal");
    }
    
    @FXML
    private void switchToFormulario() throws IOException {
        cargarVentana("formulario", 900, 600, "CRUD Actividades Turísticas");
    }
    
    private void cargarVentana(String fxml, int width, int height, String titulo) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/" + fxml + ".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root, width, height));
        stage.setTitle(titulo);
        stage.show();
    }
}