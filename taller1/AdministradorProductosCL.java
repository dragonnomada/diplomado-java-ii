package taller1;

import java.util.ArrayList;
import java.util.Scanner;

class AdministradorProductosCL {

    ArrayList<Producto> productos = new ArrayList<>();
    Scanner scanner; // REFERENCIA

    // REQUIERO: Un scanner
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    void mostrarMenu() {

        System.out.println("AdministradorProductosCL");
        System.out.println("------------------------");
        System.out.println("1. Consultar Producto");
        System.out.println("2. Ver Productos");
        System.out.println("3. Agregar Producto");
        System.out.println("4. Modificar Producto");
        System.out.println("5. Quitar Producto");
        System.out.println("6. Importar Productos");
        System.out.println("7. Exportar Productos");
        System.out.println("8. Regresar");

        int opcion = solicitarOpcion(scanner);

        seleccionarOpcion(opcion);

    }

    int solicitarOpcion(Scanner scanner) {
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    void seleccionarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                consultarProducto();
                break;
            case 2:
                verProductos();
                break;
            case 3:
                agregarProducto();
                break;
            case 4:
                modificarProducto();
                break;
            case 5:
                quitarProducto();
                break;
            case 6:
                importarProductos();
                break;
            case 7:
                exportarProductos();
                break;
            case 8:
                regresar();
                break;
            default:
                System.out.println("La opción no es válida");
                mostrarMenu();
                break;
        }
    }

    void consultarProducto() {

        String codigoBarras = solicitarCodigoBarras(scanner);

        Producto producto = buscarProductoConCodigoBarras(codigoBarras);

        mostrarProducto(producto);

    }

    String solicitarCodigoBarras(Scanner scanner) {
        System.out.print("Código de Barras: ");
        String codigoBarras = scanner.nextLine();
        return codigoBarras;
    }

    Producto buscarProductoConCodigoBarras(String codigoBarras) {
        for (Producto producto : productos) {
            if (producto.getCodigoBarras().equals(codigoBarras)) {
                return producto;
            }
        }
        return null;
    }

    void mostrarProducto(Producto producto) {
        if (producto == null) {
            System.out.println("El producto no existe :(");
        } else { // si producto != null
            System.out.println(producto);
        }
    }

    void verProductos() {}

    ArrayList<Producto> obtenerProductos() {}

    void mostrarProductos(ArrayList<Producto> productos) {}

    void agregarProducto() {}

    String solicitarNombre(Scanner scanner) {}

    double solicitarPrecio(Scanner scanner) {}

    int existencias(Scanner scanner) {}

    Producto crearProducto(String codigoBarras, String nombre, double precio, int existencias) {}

    void agregarProducto(Producto producto) {}

    void modificarProducto() {}

    boolean preguntarModificarNombre(Scanner scanner) {}

    void modificarProductoNombre(Producto producto, String nombre) {}

    boolean preguntarModificarPrecio(Scanner scanner) {}

    void modificarProductoPrecio(Producto producto, double precio) {}

    boolean preguntarModificarExistencias(Scanner scanner) {}

    boolean autorizarSupervisor(Scanner scanner) {}

    void modificarProductoExistencias(Producto producto, int existencias) {}

    void quitarProducto() {}

    void importarProductos() {}

    String solicitarArchivo(Scanner scanner) {}

    void leerProductos(String archivo) {}

    Producto leerSiguienteProducto(Scanner scanner) {}

    boolean haySiguienteProducto(Scanner scanner) {}

    void exportarProductos() {}

    String describirProducto() {}

    String descibirProductos() {}

    void escribirProductos(String archivo) {}

    void regresar() {}

}
