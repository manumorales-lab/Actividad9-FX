package co.edu.poli.actividad5.servicios;

/**
 * Representa un transporte marÃ­timo para turismo o carga.
 */
public class TransporteMaritimo {

    private int tonelaje;       // capacidad de carga en toneladas
    private String puertoOrigen;

    // Constructor por defecto
    public TransporteMaritimo() {
    }

 // Constructor con parámetros
    public TransporteMaritimo(int tonelaje, String puertoOrigen) {
    this.tonelaje = tonelaje;
    this.puertoOrigen = puertoOrigen;
    }


    // Getters y Setters
    public int getTonelaje() {
    return tonelaje;
    }


    public void setTonelaje(int tonelaje) {
    this.tonelaje = tonelaje;
    }


    public String getPuertoOrigen() {
    return puertoOrigen;
    }


    public void setPuertoOrigen(String puertoOrigen) {
    this.puertoOrigen = puertoOrigen;
    }


    // Método de negocio (ejemplo: calcular capacidad de contenedores)
    public int calcularCapacidadContenedores() {
    return tonelaje * 2; // Supongamos que cada tonelada equivale a 2 contenedores pequeños
    }


    @Override
    public String toString() {
    return "TransporteMaritimo [tonelaje=" + tonelaje +
    ", puertoOrigen=" + puertoOrigen +
    ", capacidadContenedores=" + calcularCapacidadContenedores() + "]";
    }
    }