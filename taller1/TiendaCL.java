package taller1;

import java.util.Scanner;

class TiendaCL {

    void mostrarMenu() {
        System.out.println("TiendaCL");
        System.out.println("-----------------");
        System.out.println("1. Administrador de Productos");
        System.out.println("2. Administrador de Venta");
        System.out.println("3. Salir");
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
                break;
        }
    }

    void abrirAdministradorProductos() {

    }

    void abrirAdministradorVenta() {

    }

    void salir() {

    }

}