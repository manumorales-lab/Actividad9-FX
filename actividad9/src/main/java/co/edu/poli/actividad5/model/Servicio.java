package co.edu.poli.actividad5.model;

import java.io.Serializable;

public class Servicio extends ActividadTuristica implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idServicio;
    private String transporte;
    private String alojamiento;

    public Servicio() {}

    public Servicio(String idServicio, String transporte, String alojamiento) {
        super();
        this.idServicio = idServicio;
        this.transporte = transporte;
        this.alojamiento = alojamiento;
    }

    public String getIdServicio() { return idServicio; }
    public void setIdServicio(String idServicio) { this.idServicio = idServicio; }
    public String getTransporte() { return transporte; }
    public void setTransporte(String transporte) { this.transporte = transporte; }
    public String getAlojamiento() { return alojamiento; }
    public void setAlojamiento(String alojamiento) { this.alojamiento = alojamiento; }

    protected int calcularCosto() {
        return getPrecio();
    }

    protected int calcularCosto(int descuento) {
        return getPrecio() - descuento;
    }

    @Override
    public String toString() {
        return "Servicio [idServicio=" + idServicio +
                ", transporte=" + transporte +
                ", alojamiento=" + alojamiento +
                ", costo=" + calcularCosto() +
                ", lugar=" + getLugar() +
                ", tiempo=" + getTiempo() +
                ", clima=" + getClima() +
                ", idActividad=" + getIdActividad() +
                ", precio=" + getPrecio() +
                ", tipo=" + getTipo() +
                ", anioActividad=" + getAnioActividad() + "]";
    }
}
