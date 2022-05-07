package taller1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
                mostrarMenu();
                break;
            case 2:
                verProductos();
                mostrarMenu();
                break;
            case 3:
                agregarProducto();
                mostrarMenu();
                break;
            case 4:
                modificarProducto();
                mostrarMenu();
                break;
            case 5:
                quitarProducto();
                mostrarMenu();
                break;
            case 6:
                importarProductos();
                mostrarMenu();
                break;
            case 7:
                exportarProductos();
                mostrarMenu();
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

    void importarProductos() {

        String archivo = solicitarArchivo(scanner);

        try { // CONTROLAR EL ERROR
            leerProductos(archivo);
            System.out.println("Productos importados");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        }

    }

    String solicitarArchivo(Scanner scanner) {
        System.out.print("Archivo: ");
        String archivo = scanner.nextLine();
        return archivo;
    }

    void leerProductos(String archivo) throws FileNotFoundException { // ARROJAR EL ERROR
        Scanner scannerArchivo = new Scanner(new File(archivo));

        while (haySiguienteProducto(scannerArchivo)) {
            Producto producto = leerSiguienteProducto(scannerArchivo);
            agregarProducto(producto);
        }

        scannerArchivo.close();
    }

    Producto leerSiguienteProducto(Scanner scanner) {
        String codigoBarras = scanner.nextLine();
        String nombre = scanner.nextLine();
        double precio = scanner.nextDouble(); scanner.nextLine();
        int existencias = scanner.nextInt(); scanner.nextLine();

        Producto producto = crearProducto(codigoBarras, nombre, precio, existencias);

        return producto;
    }

    boolean haySiguienteProducto(Scanner scanner) {
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("@PRODUCTO")) {
                return true;
            }
        }
        return false;
    }

    void exportarProductos() {
        String archivo = solicitarArchivo(scanner);

        try {
            escribirProductos(archivo);
            System.out.println("Productos exportados");
        } catch (IOException e) {
            System.out.println("Error al exportar los productos");
        }
    }

    String describirProducto(Producto producto) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("@PRODUCTO");
        stringBuilder.append("\n");

        stringBuilder.append(producto.getCodigoBarras());
        stringBuilder.append("\n");

        stringBuilder.append(producto.getNombre());
        stringBuilder.append("\n");

        stringBuilder.append(producto.getPrecio());
        stringBuilder.append("\n");

        stringBuilder.append(producto.getExistencias());
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    String descibirProductos() {
        String text = "";

        for (Producto producto : productos) {
            text += describirProducto(producto);
        }

        return text;
    }

    void escribirProductos(String archivo) throws IOException {

        String contenido = descibirProductos();

        FileWriter fileWriter = new FileWriter(archivo);

        fileWriter.write(contenido);

        fileWriter.close();

    }

    void regresar() {
        System.out.println("Regresando al menú principal");
    }

}
