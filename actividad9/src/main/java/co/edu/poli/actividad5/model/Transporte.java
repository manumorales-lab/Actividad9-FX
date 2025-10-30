package co.edu.poli.actividad5.model;

import java.io.Serializable;

public class Transporte implements Serializable {
    private static final long serialVersionUID = 1L;

    private String serial;
    private int capacidad;
    private int precio;      
    private String tipo;
    private int distancia;

    public Transporte() {}

    public Transporte(String serial, int capacidad, int precio, String tipo, int distancia) {
        this.serial = serial;
        this.capacidad = capacidad;
        this.precio = precio;
        this.tipo = tipo;
        this.distancia = distancia;
    }

    public String getSerial() { return serial; }
    public void setSerial(String serial) { this.serial = serial; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getDistancia() { return distancia; }
    public void setDistancia(int distancia) { this.distancia = distancia; }

    public int calcularCostoTotal() {
        return precio * distancia;
    }

    @Override
    public String toString() {
        return "Transporte [serial=" + serial +
                ", capacidad=" + capacidad +
                ", precio=" + precio +
                ", tipo=" + tipo +
                ", distancia=" + distancia +
                ", costoTotal=" + calcularCostoTotal() + "]";
    }
}
