package co.edu.poli.actividad5.servicios;
import java.io.*;
import co.edu.poli.actividad5.model.ActividadTuristica;
public class serydes {

    private static final String FILE_NAME = "actividades.bin";

    // Serializar y guardar en archivo
    public static void guardarEnArchivo(ActividadTuristica[] actividades) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(actividades);
            System.out.println(" Archivo guardado correctamente: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println(" Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Deserializar y leer del archivo
    public static ActividadTuristica[] leerDeArchivo() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println(" El archivo no existe todavía, se devuelve un arreglo vacío.");
            return new ActividadTuristica[10];
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ActividadTuristica[] actividades = (ActividadTuristica[]) ois.readObject();
            System.out.println(" Archivo leído correctamente: " + FILE_NAME);
            return actividades;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" Error al leer el archivo: " + e.getMessage());
            return new ActividadTuristica[10];
        }
    }
}
