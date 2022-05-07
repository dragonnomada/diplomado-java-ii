package t01_conceptos;

import java.util.Scanner;

public class CapturarLibro implements IProducto {

    static int globalId = 1;

    int id;
    String titulo;
    String autor;

    public void capturar(Scanner scanner) {
        id = globalId++;

        System.out.print("Título: ");
        titulo = scanner.nextLine();

        System.out.print("Autor: ");
        autor = scanner.nextLine();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return String.format("Libro '%s' por %s", titulo, autor);
    }

    @Override
    public double getPrecio() {
        return 9.99;
    }

    @Override
    public int getExistencias() {
        return 100;
    }
}
