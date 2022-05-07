package entities;

public class Libro implements IVendible, IDescribible, IAnualizable {

    int id;
    String titulo;
    String autor;
    int year;

    public int getYear() {
        return year;
    }

    public String getDescripcion() {
        return String.format("Libro '%s' de %s (%d)", titulo, autor, year);
    }

    public double getImporte() {
        // TODO: Ve a la bases de datos y calcula el importe del libro con tal id
        return 9.99;
    }

    public int getExistencias() {
        // TODO: Ve a la bases de datos y calcula las existencias del libro con tal id
        return 1;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", year=" + year +
                '}';
    }
}
