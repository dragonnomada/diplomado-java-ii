package t01_conceptos;

import java.util.Scanner;

class CaptudadorProducto {

    int capturarExistencias(Scanner scanner) {
        System.out.print("Dame las existencias: ");
        int existencias;
        try {
            existencias = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("No se pudo capturar las existencias");
            return capturarExistencias(scanner); // RECURSIVIDAD
        }
        scanner.nextLine();
        return existencias;
    }

}

public class TestCapturarProducto {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CaptudadorProducto captudadorProducto = new CaptudadorProducto();

        int existencias = captudadorProducto.capturarExistencias(scanner);

        System.out.printf("Las existencias son: %d", existencias);

        scanner.close();

    }

}
