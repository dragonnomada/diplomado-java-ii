package taller1;

import java.util.Scanner;

class TiendaCL {

    AdministradorProductosCL administradorProductosCL = new AdministradorProductosCL();
    AdministradorVentaCL administradorVentaCL = new AdministradorVentaCL();
    Scanner scanner = new Scanner(System.in);

    void mostrarMenu() {
        System.out.println("TiendaCL");
        System.out.println("-----------------");
        System.out.println("1. Administrador de Productos");
        System.out.println("2. Administrador de Venta");
        System.out.println("3. Salir");

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
                abrirAdministradorProductos();
                break;
            case 2:
                abrirAdministradorVenta();
                break;
            case 3:
                salir();
                break;
            default:
                System.out.println("Opción no válida");
                mostrarMenu();
                break;
        }
    }

    void abrirAdministradorProductos() {
        administradorProductosCL.setScanner(scanner);
        administradorProductosCL.mostrarMenu();
        mostrarMenu();
    }

    void abrirAdministradorVenta() {
        administradorVentaCL.mostrarMenu();
        mostrarMenu();
    }

    void salir() {
        scanner.close();
        System.out.println("Fin del programa");
    }

}