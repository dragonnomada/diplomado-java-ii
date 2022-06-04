import java.io.Serializable;
import java.util.Scanner;

public class Producto implements Serializable {

    private int id;
    private String nombre;
    private double precio;
    private boolean activo;

    public Producto(Scanner scanner) {
        System.out.println("Capturar datos del producto");
        System.out.println("------------------------------------");
        System.out.print("ID: ");
        this.id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nombre: ");
        this.nombre = scanner.nextLine();
        System.out.print("Precio: ");
        this.precio = scanner.nextDouble(); scanner.nextLine();
        System.out.print("¿Actio? [1: SI 0: NO]: ");
        this.activo = scanner.nextInt() == 1; scanner.nextLine();
    }

    public Producto(int id, String nombre, double precio, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", activo=" + activo +
                '}';
    }
}
