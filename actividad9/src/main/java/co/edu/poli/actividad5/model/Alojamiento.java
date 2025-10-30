package co.edu.poli.actividad5.model;

import java.io.Serializable;

public class Alojamiento implements Serializable {
    private static final long serialVersionUID = 1L;

    private int precio;
    private int capacidad;
    private String ubicacion;
    private String idAlojamiento;
    private String nombre;
    private int estrellas;

    public Alojamiento() {}

    public Alojamiento(int precio, int capacidad, String ubicacion, String idAlojamiento, String nombre, int estrellas) {
        this.precio = precio;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.idAlojamiento = idAlojamiento;
        this.nombre = nombre;
        this.estrellas = estrellas;
    }

    @Override
    public String toString() {
        return "Alojamiento [precio=" + precio +
                ", capacidad=" + capacidad +
                ", ubicacion=" + ubicacion +
                ", idAlojamiento=" + idAlojamiento +
                ", nombre=" + nombre +
                ", estrellas=" + estrellas + "]";
    }
}
