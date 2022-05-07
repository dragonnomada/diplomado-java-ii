package t01_conceptos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCapturarEnArchivos {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("C:\\test\\data.txt"));

        String linea1 = scanner.nextLine();
        String linea2 = scanner.nextLine();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine(); // linea3
        String linea4 = scanner.nextLine();

        System.out.println(linea1);
        System.out.println(linea2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(linea4);

        scanner.close();

    }

}
