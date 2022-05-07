package taller1;

import java.util.ArrayList;
import java.util.Scanner;

class AdministradorVentaCL {

    ArrayList<ProductoVenta> productosVenta = new ArrayList<>();

    AdministradorProductosCL administradorProductosCL;
    Scanner scanner;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setAdministradorProductosCL(AdministradorProductosCL administradorProductosCL) {
        this.administradorProductosCL = administradorProductosCL;
    }

    void mostrarMenu() {

        System.out.println("AdministradorVentaCL");
        System.out.println("--------------------------");
        System.out.println("1. Consultar Venta");
        System.out.println("2. Consultar Producto");
        System.out.println("3. Agregar Producto a Venta");
        System.out.println("4. Quitar Producto de Venta");
        System.out.println("5. Completar Venta");
        System.out.println("6. Cancelar Venta");
        System.out.println("7. Regresar");


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
                consultarVenta();
                mostrarMenu();
                break;
            case 2:
                consultarProducto();
                mostrarMenu();
                break;
            case 3:
                agregarProductoVenta();
                mostrarMenu();
                break;
            case 4:
                quitarProductoVenta();
                mostrarMenu();
                break;
            case 5:
                completarVenta();
                mostrarMenu();
                break;
            case 6:
                cancelarVenta();
                mostrarMenu();
                break;
            case 7:
                regresar();
                break;
            default:
                System.out.println("La opción no es válida");
                mostrarMenu();
                break;
        }
    }

    void consultarVenta() {

        ArrayList<ProductoVenta> productosVenta = obtenerProductosVenta();

        mostrarProductosVenta(productosVenta);

        double total = calcularTotal(productosVenta);

        System.out.printf("Total: $%.2f\n", total);

    }

    ArrayList<ProductoVenta> obtenerProductosVenta() {
        return productosVenta;
    }

    void mostrarProductosVenta(ArrayList<ProductoVenta> productosVenta) {

        for (ProductoVenta productoVenta : productosVenta) {
            mostrarProductoVenta(productoVenta);
        }

    }

    void mostrarProductoVenta(ProductoVenta productoVenta) {
        if (productoVenta != null) {
            System.out.println(productoVenta);
        } else {
            System.out.println("El producto venta no existe");
        }
    }

    double calcularTotal(ArrayList<ProductoVenta> productosVenta) {
        double total = 0;

        for (ProductoVenta productoVenta : productosVenta) {
            total += productoVenta.getPrecioTotal();
        }

        return total;
    }

    void consultarProducto() {
        administradorProductosCL.consultarProducto();
    }

    void agregarProductoVenta() {

        String codigoBarras = administradorProductosCL.solicitarCodigoBarras(scanner);

        Producto producto = administradorProductosCL.buscarProductoConCodigoBarras(codigoBarras);

        administradorProductosCL.mostrarProducto(producto);

        if (producto != null) {

            int cantidad = solicitarCantidad(scanner);
            double precioUnitario = obtenerPrecioUnitario(producto);
            double precioTotal = obtenerPrecioTotal(producto, cantidad);

            ProductoVenta productoVenta = crearProductoVenta(producto, cantidad, precioUnitario, precioTotal);

            agregarProductoVenta(productoVenta);

        }

    }

    int solicitarCantidad(Scanner scanner) {
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        return cantidad;
    }

    double obtenerPrecioUnitario(Producto producto) {
        return producto.getPrecio();
    }

    double obtenerPrecioTotal(Producto producto, int cantidad) {
        return producto.getPrecio() * cantidad;
    }

    ProductoVenta crearProductoVenta(Producto producto, int cantidad, double precioUnitario, double precioTotal) {
        ProductoVenta productoVenta = new ProductoVenta(producto, cantidad, precioUnitario, precioTotal);

        return productoVenta;
    }

    void agregarProductoVenta(ProductoVenta productoVenta) {
        productosVenta.add(productoVenta);
    }

    void quitarProductoVenta() {
        String codigoBarras = administradorProductosCL.solicitarCodigoBarras(scanner);

        if (autorizarSupervisor(scanner)) {
            ProductoVenta productoVenta = buscarProductoVenta(codigoBarras);

            quitarProductoVenta(productoVenta);
        }
    }

    boolean autorizarSupervisor(Scanner scanner) {
        System.out.print("Dame la clave del supervisor: ");
        String claveSupervisor = scanner.nextLine();

        if (claveSupervisor.equals("1234b")) {
            return true;
        } else {
            return false;
        }
    }

    ProductoVenta buscarProductoVenta(String codigoBarras) {
        for (ProductoVenta productoVenta : productosVenta) {
            if (productoVenta.getProducto().getCodigoBarras().equals(codigoBarras)) {
                return productoVenta;
            }
        }
        return null;
    }

    void quitarProductoVenta(ProductoVenta productoVenta) {
        productosVenta.remove(productoVenta);
    }

    void completarVenta() {
        double importe = solicitarImporte(scanner);

        double total = calcularTotal(productosVenta);

        if (importe >= total) {
            String pago = solicitarPago(scanner, productosVenta, total);

            System.out.printf("DEVUELVE: %.2f\n", importe - total);

            imprimirTicket(productosVenta, total, pago);
        }

    }

    double solicitarImporte(Scanner scanner) {
        System.out.print("Importe: ");
        double importe = scanner.nextDouble();
        scanner.nextLine();
        return importe;
    }

    String solicitarPago(Scanner scanner, ArrayList<ProductoVenta> productosVenta, double total) {
        return "OK";
    }

    void imprimirTicket(ArrayList<ProductoVenta> productosVenta, double total, String pago) {
        System.out.println("TICKET AQUÍ");
    }

    void cancelarVenta() {
        if (autorizarSupervisor(scanner)) {
            for (ProductoVenta productoVenta : productosVenta) {
                quitarProductoVenta(productoVenta);
            }
        }
    }

    void regresar() {
        System.out.println("Regresando al menú principal");
    }

}
