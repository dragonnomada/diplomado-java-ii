package taller1;

import java.util.ArrayList;
import java.util.Scanner;

class AdministradorProductosCL {

    void mostrarMenu() {}

    int solicitarOpcion(Scanner scanner) {}

    void seleccionarOpcion(int opcion) {}

    void consultarProducto() {}

    String solicitarCodigoBarras(Scanner scanner) {}

    Producto buscarProductoConCodigoBarras(String codigoBarras) {}

    void mostrarProducto(Producto producto) {}

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
