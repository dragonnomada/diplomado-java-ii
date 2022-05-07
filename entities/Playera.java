package entities;

public class Playera implements IVendible, IDescribible {

    int id;
    String color;
    String marca;
    String modelo;
    boolean paraMujer;

    public String getDescripcion() {
        return String.format("Playera de la marca %s, modelo %s color %s", marca, modelo, color);
    }

    public double getImporte() {
        // TODO: Ve a la bases de datos y calcula el importe de la playera con tal id
        if (paraMujer) {
            return 150;
        } else {
            return 250.99;
        }
    }

    public int getExistencias() {
        // TODO: Ve a la bases de datos y calcula las existencias de las playeras con tal id
        return 3;
    }

    @Override
    public String toString() {
        return "Playera{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", paraMujer=" + paraMujer +
                '}';
    }
}
