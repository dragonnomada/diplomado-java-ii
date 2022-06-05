import java.io.Serializable;

public class Coordenada implements Serializable {

    private double latitud;
    private double longitud;

    public Coordenada(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    @Override
    public String toString() {
        return "Coordenada{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
