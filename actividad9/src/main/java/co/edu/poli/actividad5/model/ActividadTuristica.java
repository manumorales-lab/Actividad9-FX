package co.edu.poli.actividad5.model;

import java.io.Serializable;

/**
 * Representa una actividad tur�stica en un destino.
 */
public class ActividadTuristica implements Serializable {

    private static final long serialVersionUID = 1L;

    private String lugar;
    private String tiempo;
    private String clima;
    private String idActividad;
    private int precio;
    private String tipo;
    private int anioActividad;

    // Constructor por defecto
    public ActividadTuristica() {
    }

    // Constructor con par�metros
    public ActividadTuristica(String lugar, String tiempo, String clima, String idActividad,
                              int precio, String tipo, int anioActividad) {
        this.lugar = lugar;
        this.tiempo = tiempo;
        this.clima = clima;
        this.idActividad = idActividad;
        this.precio = precio;
        this.tipo = tipo;
        this.anioActividad = anioActividad;
    }

    // Getters y Setters
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAnioActividad() {
        return anioActividad;
    }

    public void setAnioActividad(int anioActividad) {
        if (anioActividad > 0) {
            this.anioActividad = anioActividad;
        }
    }

    @Override
    public String toString() {
        return "ActividadTuristica [lugar=" + lugar + ", tiempo=" + tiempo +
                ", clima=" + clima + ", idActividad=" + idActividad +
                ", precio(en dolares y un numero cerrado)=" + precio + ", tipo=" + tipo +
                ", anioActividad=" + anioActividad + "]";
    }
}
