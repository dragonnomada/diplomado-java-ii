package taller1;

import java.util.ArrayList;
import java.util.Scanner;

class AdministradorVentaCL {

    void mostrarMenu() {}

    int solicitarOpcion(Scanner scanner) {}

    void seleccionarOpcion(int opcion) {}

    void consultarVenta() {}

    ArrayList<ProductoVenta> obtenerProductosVenta() {}

    void mostrarProductosVenta(ArrayList<ProductoVenta> productosVenta) {}

    void mostrarProductoVenta(ProductoVenta productoVenta) {}

    double calcularTotal(ArrayList<ProductoVenta> productosVenta) {}

    void consultarProducto() {}

    void agregarProductoVenta() {}

    int solicitarCantidad(Scanner scanner) {}

    double obtenerPrecioUnitario(Producto producto) {}

    double obtenerPrecioTotal(Producto producto, int cantidad) {}

    ProductoVenta crearProductoVenta(Producto producto, int cantidad, double precioUnitario, double precioTotal) {}

    void agregarProductoVenta(ProductoVenta productoVenta) {}

    void quitarProductoVenta() {}

    boolean autorizarSupervisor(Scanner scanner) {}

    ProductoVenta buscarProductoVenta(String codigoBarras) {}

    void quitarProductoVenta(ProductoVenta productoVenta) {}

    void completarVenta() {}

    double solicitarImporte(Scanner scanner) {}

    String solicitarPago(Scanner scanner, ArrayList<ProductoVenta> productosVenta, double total) {}

    void imprimirTicket(ArrayList<ProductoVenta> productosVenta, double total, String pago) {}

    void cancelarVenta() {}

    void regresar() {}

}
