package co.edu.poli.actividad5.model;

import java.io.Serializable;

public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int precio;
    private int duracion;
    private int capacidad;
    private String fecha;
    private String idActividad;

    public Actividad() {}

    public Actividad(String nombre, int precio, int duracion, int capacidad, String fecha, String idActividad) {
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;
        this.capacidad = capacidad;
        this.fecha = fecha;
        this.idActividad = idActividad;
    }

    @Override
    public String toString() {
        return "Actividad [nombre=" + nombre +
                ", precio=" + precio +
                ", duracion=" + duracion +
                ", capacidad=" + capacidad +
                ", fecha=" + fecha +
                ", idActividad=" + idActividad + "]";
    }
}
