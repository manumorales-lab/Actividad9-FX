package co.edu.poli.actividad5.model;

import java.io.Serializable;

public class Destino implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ciudad;
    private String lugar;
    private String departamento;
    private String region;
    private String idDestino;

    public Destino() {}

    public Destino(String ciudad, String lugar, String departamento, String region, String idDestino) {
        this.ciudad = ciudad;
        this.lugar = lugar;
        this.departamento = departamento;
        this.region = region;
        this.idDestino = idDestino;
    }

    @Override
    public String toString() {
        return "Destino [ciudad=" + ciudad +
                ", lugar=" + lugar +
                ", departamento=" + departamento +
                ", region=" + region +
                ", idDestino=" + idDestino + "]";
    }
}
