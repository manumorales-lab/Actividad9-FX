package co.edu.poli.actividad5.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idCliente;
    private int edad;
    private String nombre;
    private boolean activo;

    public Cliente() {}

    public Cliente(String idCliente, int edad, String nombre, boolean activo) {
        this.idCliente = idCliente;
        this.edad = edad;
        this.nombre = nombre;
        this.activo = activo;
    }

    public String getIdCliente() { return idCliente; }
    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente +
                ", edad=" + edad +
                ", nombre=" + nombre +
                ", activo=" + activo + "]";
    }
}
