package es.joseljg.viajes.clases;

import java.io.Serializable;
import java.util.Objects;

public class Viaje implements Serializable {
    private int idviaje;
    private String origen;
    private String destino;
    private double precio;
    //---------------------------------------

    public Viaje(String origen, String destino, double precio) {
        this.idviaje = 0;
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Viaje)) return false;
        Viaje viaje = (Viaje) o;
        return idviaje == viaje.idviaje;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idviaje);
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "idviaje=" + idviaje +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", precio=" + precio +
                '}';
    }
}
