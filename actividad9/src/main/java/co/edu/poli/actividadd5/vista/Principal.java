package co.edu.poli.actividadd5.vista;

import java.util.Scanner;

import co.edu.poli.actividad5.model.ActividadTuristica;
import co.edu.poli.actividad5.servicios.*;

public class Principal {

    private static ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ActividadTuristica[] actividades = serydes.leerDeArchivo();
        // Cargamos lo leído en el CRUD
        for (ActividadTuristica a : actividades) {
            if (a != null) {
                crud.create(a);
            }
        }

        int opcion;
        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Crear Actividad Turística");
            System.out.println("2. Listar todas las Actividades");
            System.out.println("3. Listar una Actividad por ID");
            System.out.println("4. Guardar en Archivo");
            System.out.println("5. Cargar desde Archivo");
            System.out.println("6. Modificar Actividad");
            System.out.println("7. Eliminar Actividad");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            
            // SWITCH TRADICIONAL (compatible con Java 8+)
            switch (opcion) {
                case 1:
                    crearActividad();
                    break;
                case 2:
                    listarTodas();
                    break;
                case 3:
                    listarUna();
                    break;
                case 4:
                    guardarArchivo();
                    break;
                case 5:
                    cargarArchivo();
                    break;
                case 6:
                    modificarActividad();
                    break;
                case 7:
                    eliminarActividad();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        } while (opcion != 8);
        
        sc.close(); // Cerrar scanner
    }

    private static void crearActividad() {
        // Verificar límite de almacenamiento (10 actividades)
        int contador = 0;
        for (ActividadTuristica a : crud.listAll()) {
            if (a != null) contador++;
        }
        
        if (contador >= 10) {
            System.out.println(" No se pueden guardar más de 10 actividades.");
            return;
        }

        System.out.print("Ingrese ID: ");
        String id = sc.nextLine();
        System.out.print("Ingrese lugar: ");
        String lugar = sc.nextLine();
        System.out.print("Ingrese tiempo: ");
        String tiempo = sc.nextLine();
        System.out.print("Ingrese clima: ");
        String clima = sc.nextLine();
        System.out.print("Ingrese precio (en dolares): ");
        int precio = sc.nextInt();
        System.out.print("Ingrese año: ");
        int anio = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        System.out.print("Ingrese tipo: ");
        String tipo = sc.nextLine();

        ActividadTuristica act = new ActividadTuristica(lugar, tiempo, clima, id, precio, tipo, anio);
        if (crud.create(act)) {
            System.out.println("Actividad creada exitosamente.");
        } else {
            System.out.println("No se pudo crear la actividad (ID duplicado o espacio insuficiente).");
        }
    }

    private static void listarTodas() {
        System.out.println("\n=== LISTADO DE ACTIVIDADES ===");
        boolean hayActividades = false;
        for (ActividadTuristica a : crud.listAll()) {
            if (a != null) {
                System.out.println(a);
                hayActividades = true;
            }
        }
        if (!hayActividades) {
            System.out.println("No hay actividades registradas.");
        }
    }

    private static void listarUna() {
        System.out.print("Ingrese ID de la actividad: ");
        String id = sc.nextLine();
        ActividadTuristica act = crud.read(id);
        if (act != null) {
            System.out.println("Actividad encontrada: " + act);
        } else {
            System.out.println("Actividad no encontrada.");
        }
    }

    private static void guardarArchivo() {
        serydes.guardarEnArchivo(crud.listAll());
        System.out.println("Datos guardados en archivo correctamente.");
    }

    private static void cargarArchivo() {
        ActividadTuristica[] actividades = serydes.leerDeArchivo();
        int cargadas = 0;
        for (ActividadTuristica a : actividades) {
            if (a != null) {
                crud.create(a);
                cargadas++;
            }
        }
        System.out.println("Se cargaron " + cargadas + " actividades desde el archivo.");
    }

    private static void modificarActividad() {
        System.out.print("Ingrese ID de la actividad a modificar: ");
        String id = sc.nextLine();
        ActividadTuristica existente = crud.read(id);
        if (existente == null) {
            System.out.println("Actividad no encontrada.");
            return;
        }

        System.out.println("Actividad actual: " + existente);
        System.out.println("Ingrese los nuevos datos:");

        System.out.print("Nuevo lugar: ");
        String lugar = sc.nextLine();
        System.out.print("Nuevo tiempo: ");
        String tiempo = sc.nextLine();
        System.out.print("Nuevo clima: ");
        String clima = sc.nextLine();
        System.out.print("Nuevo precio: ");
        int precio = sc.nextInt();
        System.out.print("Nuevo año: ");
        int anio = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo tipo: ");
        String tipo = sc.nextLine();

        ActividadTuristica nueva = new ActividadTuristica(lugar, tiempo, clima, id, precio, tipo, anio);
        if (crud.update(id, nueva)) {
            System.out.println("Actividad modificada correctamente.");
        } else {
            System.out.println("Error al modificar la actividad.");
        }
    }

    private static void eliminarActividad() {
        System.out.print("Ingrese ID de la actividad a eliminar: ");
        String id = sc.nextLine();
        if (crud.delete(id)) {
            System.out.println("Actividad eliminada.");
        } else {
            System.out.println("No se pudo eliminar (ID no encontrado).");
        }
    }
}