package t01_conceptos;

import java.util.Scanner;

public class VenderProducto implements IVenta {

    String descripcion;
    double precio;

    @Override
    public void setProducto(IProducto producto) {
        descripcion = String.format("[%d] %s $%.2f", producto.getId(), producto.getNombre(), producto.getPrecio());
        precio = producto.getPrecio();
    }

    void vender(Scanner scanner) {
        System.out.println(descripcion);

        if (precio <= 0) {
            System.out.println("El precio no es válido, no se efectuará la venta");
            return;
        }

        System.out.print("¿Completar venta? [S/N] ");
        String respuesta = scanner.nextLine();

        if (respuesta.equals("S") || respuesta.equals("s")) {
            System.out.printf("Se vendió el producto a $%.2f\n", precio);
        } else {
            System.out.println("No pudo vender el producto");
        }
    }

    public static void main(String[] args) {

        // Abrimos una venta
        VenderProducto venta = new VenderProducto();

        // Abrimos un capturador de libro
        CapturarLibro libro = new CapturarLibro();

        // Abrimos un escáner
        Scanner scanner = new Scanner(System.in);

        // Solicitamos capturar el libro desde el usuario
        libro.capturar(scanner);

        // Solicitamos ajustar el libro como producto de la venta
        venta.setProducto(libro);

        // Solicitamos vender el libro
        venta.vender(scanner);

        // Solicitamos cerrar el escáner
        scanner.close();

    }
}
