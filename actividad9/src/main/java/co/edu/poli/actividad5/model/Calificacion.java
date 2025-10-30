package co.edu.poli.actividad5.model;

import java.io.Serializable;

public class Calificacion implements Serializable {
    private static final long serialVersionUID = 1L;

    private int puntaje;
    private String idCalificacion;
    private String comentario;

    public Calificacion() {}

    public Calificacion(int puntaje, String idCalificacion, String comentario) {
        this.puntaje = puntaje;
        this.idCalificacion = idCalificacion;
        this.comentario = comentario;
    }

    public int getPuntaje() { return puntaje; }
    public void setPuntaje(int puntaje) { this.puntaje = puntaje; }
    public String getIdCalificacion() { return idCalificacion; }
    public void setIdCalificacion(String idCalificacion) { this.idCalificacion = idCalificacion; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    @Override
    public String toString() {
        return "Calificacion [puntaje=" + puntaje +
                ", idCalificacion=" + idCalificacion +
                ", comentario=" + comentario + "]";
    }
}
