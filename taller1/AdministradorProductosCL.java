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

    void verProductos() {

        ArrayList<Producto> productos = obtenerProductos();

        mostrarProductos(productos);

    }

    ArrayList<Producto> obtenerProductos() {
        return productos;
    }

    void mostrarProductos(ArrayList<Producto> productos) {
        for (Producto producto : productos) {
            mostrarProducto(producto);
        }
    }

    void agregarProducto() {

        String codigoBarras = solicitarCodigoBarras(scanner);
        String nombre = solicitarNombre(scanner);
        double precio = solicitarPrecio(scanner);
        int existencias = solicitarExistencias(scanner);

        Producto producto = crearProducto(codigoBarras, nombre, precio, existencias);

        agregarProducto(producto);

    }

    String solicitarNombre(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        return nombre;
    }

    double solicitarPrecio(Scanner scanner) {
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        return precio;
    }

    int solicitarExistencias(Scanner scanner) {
        System.out.print("Precio: ");
        int existencias = scanner.nextInt();
        scanner.nextLine();
        return existencias;
    }

    Producto crearProducto(String codigoBarras, String nombre, double precio, int existencias) {
        Producto producto = new Producto(codigoBarras, nombre, precio, existencias);
        return producto;
    }

    void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    void modificarProducto() {

        String codigoBarras = solicitarCodigoBarras(scanner);

        Producto producto = buscarProductoConCodigoBarras(codigoBarras);

        mostrarProducto(producto);

        if (producto != null) {
            if (preguntarModificarNombre(scanner)) {
                String nombre = solicitarNombre(scanner);
                modificarProductoNombre(producto, nombre);
            }

            if (preguntarModificarPrecio(scanner)) {
                double precio = solicitarPrecio(scanner);
                modificarProductoPrecio(producto, precio);
            }

            if (preguntarModificarExistencias(scanner)) {
                if (autorizarSupervisor(scanner)) {
                    int existencias = solicitarExistencias(scanner);
                    modificarProductoExistencias(producto, existencias);
                }
            }
        }

    }

    boolean preguntarModificarNombre(Scanner scanner) {
        System.out.println("¿Quieres modificar el nombre?");
        System.out.println("1. SI");
        System.out.println("2. NO");

        int opcion = solicitarOpcion(scanner);

        if (opcion == 1) {
            return true;
        } else {
            return false;
        }
    }

    void modificarProductoNombre(Producto producto, String nombre) {
        producto.setNombre(nombre);
    }

    boolean preguntarModificarPrecio(Scanner scanner) {
        System.out.println("¿Quieres modificar el precio?");
        System.out.println("1. SI");
        System.out.println("2. NO");

        int opcion = solicitarOpcion(scanner);

        if (opcion == 1) {
            return true;
        } else {
            return false;
        }
    }

    void modificarProductoPrecio(Producto producto, double precio) {
        producto.setPrecio(precio);
    }

    boolean preguntarModificarExistencias(Scanner scanner) {
        System.out.println("¿Quieres modificar las existencia?");
        System.out.println("1. SI");
        System.out.println("2. NO");

        int opcion = solicitarOpcion(scanner);

        if (opcion == 1) {
            return true;
        } else {
            return false;
        }
    }

    boolean autorizarSupervisor(Scanner scanner) {
        System.out.print("Dame la clave del supervisor: ");
        String claveSupervisor = scanner.nextLine();

        if (claveSupervisor.equals("1234a")) {
            return true;
        } else {
            return false;
        }
    }

    void modificarProductoExistencias(Producto producto, int existencias) {
        producto.setExistencias(existencias);
    }

    void quitarProducto() {
        String codigoBarras = solicitarCodigoBarras(scanner);

        Producto producto = buscarProductoConCodigoBarras(codigoBarras);

        mostrarProducto(producto);

        if (producto != null) {
            productos.remove(producto);
        }
    }

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
