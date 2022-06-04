import java.io.*;
import java.util.Scanner;

public class TestProductoInput {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Producto ID: ");
        int id = scanner.nextInt(); scanner.nextLine();

        InputStream inputStream = new FileInputStream(String.format("C:\\test\\producto_%d.dat", id));
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        // producto_xxx.dat -> inputStream -> bytes[] -*> producto
        Producto producto = (Producto)objectInputStream.readObject(); // Recupera el objeto `producto` desde la tubería

        System.out.println(producto);

        inputStream.close();

    }

}
