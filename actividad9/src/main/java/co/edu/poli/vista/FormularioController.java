package co.edu.poli.vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import co.edu.poli.actividad5.model.ActividadTuristica;
import co.edu.poli.actividad5.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.actividad5.servicios.serydes;

import java.io.IOException;

public class FormularioController {

    private ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();
    private ObservableList<ActividadTuristica> actividadesList = FXCollections.observableArrayList();

    // Componentes del formulario
    @FXML private TextField txtIdActividad;
    @FXML private TextField txtLugar;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtTipo;
    @FXML private TextField txtAnio;
    @FXML private TextField txtClima;
    @FXML private TextField txtTiempo;
    
    @FXML private CheckBox chkJava;
    @FXML private CheckBox chkPython;
    @FXML private CheckBox chkNode;
    
    @FXML private Button btnGuardar;
    @FXML private Button btnModificar;
    @FXML private Button btnEliminar;
    @FXML private Button btnSerializar;
    @FXML private Button btnDeserializar;
    
    // Tabla y columnas
    @FXML private TableView<ActividadTuristica> tblActividades;
    @FXML private TableColumn<ActividadTuristica, String> colId;
    @FXML private TableColumn<ActividadTuristica, String> colLugar;
    @FXML private TableColumn<ActividadTuristica, String> colTipo;
    @FXML private TableColumn<ActividadTuristica, Integer> colPrecio;
    @FXML private TableColumn<ActividadTuristica, String> colClima;
    @FXML private TableColumn<ActividadTuristica, String> colTiempo;
    @FXML private TableColumn<ActividadTuristica, Integer> colAnio;
    @FXML private TableColumn<ActividadTuristica, String> colHabilidades;

    @FXML
    public void initialize() {
        // Configurar las columnas de la tabla
        configurarTabla();
        
        // Cargar datos iniciales
        cargarDatosIniciales();
        
        // Configurar eventos de la tabla
        tblActividades.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> mostrarDatosSeleccionados(newValue)
        );
    }

    private void configurarTabla() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idActividad"));
        colLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colClima.setCellValueFactory(new PropertyValueFactory<>("clima"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anioActividad"));
        colHabilidades.setCellValueFactory(new PropertyValueFactory<>("habilidades"));
        
        tblActividades.setItems(actividadesList);
    }

    private void cargarDatosIniciales() {
        // Cargar desde archivo si existe
        ActividadTuristica[] actividades = serydes.leerDeArchivo();
        for (ActividadTuristica actividad : actividades) {
            if (actividad != null) {
                crud.create(actividad);
                actividadesList.add(actividad);
            }
        }
    }

    private void mostrarDatosSeleccionados(ActividadTuristica actividad) {
        if (actividad != null) {
            txtIdActividad.setText(actividad.getIdActividad());
            txtLugar.setText(actividad.getLugar());
            txtTiempo.setText(actividad.getTiempo());
            txtClima.setText(actividad.getClima());
            txtPrecio.setText(String.valueOf(actividad.getPrecio()));
            txtAnio.setText(String.valueOf(actividad.getAnioActividad()));
            txtTipo.setText(actividad.getTipo().replaceAll("\\s*\\[.*\\]", "")); // Remover habilidades del tipo
            
            // Limpiar checkboxes
            chkJava.setSelected(false);
            chkPython.setSelected(false);
            chkNode.setSelected(false);
            
            // Configurar habilidades basado en el tipo
            String tipoCompleto = actividad.getTipo().toLowerCase();
            if (tipoCompleto.contains("java")) {
                chkJava.setSelected(true);
            }
            if (tipoCompleto.contains("python")) {
                chkPython.setSelected(true);
            }
            if (tipoCompleto.contains("node")) {
                chkNode.setSelected(true);
            }
        }
    }

    @FXML
    private void guardarActividad() {
        if (validarCampos()) {
            ActividadTuristica actividad = crearActividadDesdeFormulario();
            
            if (crud.create(actividad)) {
                actividadesList.add(actividad);
                limpiarFormulario();
                mostrarAlerta("Éxito", "Actividad guardada correctamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "No se pudo guardar la actividad (ID duplicado o espacio insuficiente)", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    private void modificarActividad() {
        ActividadTuristica seleccionada = tblActividades.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarAlerta("Error", "Seleccione una actividad para modificar", Alert.AlertType.WARNING);
            return;
        }
        
        if (validarCampos()) {
            ActividadTuristica actividadActualizada = crearActividadDesdeFormulario();
            
            if (crud.update(seleccionada.getIdActividad(), actividadActualizada)) {
                actividadesList.remove(seleccionada);
                actividadesList.add(actividadActualizada);
                limpiarFormulario();
                mostrarAlerta("Éxito", "Actividad modificada correctamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "Error al modificar la actividad", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    private void eliminarActividad() {
        ActividadTuristica seleccionada = tblActividades.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarAlerta("Error", "Seleccione una actividad para eliminar", Alert.AlertType.WARNING);
            return;
        }
        
        if (crud.delete(seleccionada.getIdActividad())) {
            actividadesList.remove(seleccionada);
            limpiarFormulario();
            mostrarAlerta("Éxito", "Actividad eliminada correctamente", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Error", "Error al eliminar la actividad", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void serializarDatos() {
        serydes.guardarEnArchivo(actividadesList.toArray(new ActividadTuristica[0]));
        mostrarAlerta("Éxito", "Datos serializados correctamente", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void deserializarDatos() {
        actividadesList.clear();
        cargarDatosIniciales();
        mostrarAlerta("Éxito", "Datos deserializados correctamente", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void volverMenuPrincipal() throws IOException {
        // Cerrar ventana actual y abrir menú principal
        Stage currentStage = (Stage) btnGuardar.getScene().getWindow();
        currentStage.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("/primary.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("Menú Principal");
        stage.show();
    }

    @FXML
    private void limpiarFormulario() {
        txtIdActividad.clear();
        txtLugar.clear();
        txtTiempo.clear();
        txtClima.clear();
        txtPrecio.clear();
        txtAnio.clear();
        txtTipo.clear();
        
        chkJava.setSelected(false);
        chkPython.setSelected(false);
        chkNode.setSelected(false);
        
        tblActividades.getSelectionModel().clearSelection();
    }

    private ActividadTuristica crearActividadDesdeFormulario() {
        String habilidades = obtenerHabilidadesSeleccionadas();
        String tipoCompleto = txtTipo.getText();
        
        if (!habilidades.isEmpty()) {
            tipoCompleto += " [" + habilidades + "]";
        }
        
        return new ActividadTuristica(
            txtLugar.getText(),
            txtTiempo.getText(),
            txtClima.getText(),
            txtIdActividad.getText(),
            Integer.parseInt(txtPrecio.getText()),
            tipoCompleto,
            Integer.parseInt(txtAnio.getText())
        );
    }

    private String obtenerHabilidadesSeleccionadas() {
        StringBuilder habilidades = new StringBuilder();
        if (chkJava.isSelected()) habilidades.append("Java ");
        if (chkPython.isSelected()) habilidades.append("Python ");
        if (chkNode.isSelected()) habilidades.append("Node");
        return habilidades.toString().trim();
    }

    private boolean validarCampos() {
        if (txtIdActividad.getText().isEmpty() || txtLugar.getText().isEmpty() ||
            txtPrecio.getText().isEmpty() || txtTipo.getText().isEmpty() ||
            txtAnio.getText().isEmpty() || txtClima.getText().isEmpty() ||
            txtTiempo.getText().isEmpty()) {
            
            mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
            return false;
        }
        
        try {
            Integer.parseInt(txtPrecio.getText());
            Integer.parseInt(txtAnio.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Precio y Año deben ser números válidos", Alert.AlertType.ERROR);
            return false;
        }
        
        return true;
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}