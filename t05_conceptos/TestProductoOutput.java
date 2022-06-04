import java.io.*;
import java.util.Scanner;

public class TestProductoOutput {

    public static void main(String[] args) throws IOException {

        //Producto producto = new Producto(123, "Coca Cola", 18.5, true);

        Scanner scanner = new Scanner(System.in);

        Producto producto = new Producto(scanner); // SERIALIZABLE

        System.out.println(producto);

        // 1. Determinar a dónde irá el stream de bytes de salida
        OutputStream outputStream = new FileOutputStream(String.format("C:\\test\\producto_%d.dat", producto.getId()));
        // 2. Ajustar un serializador de objetos hacia el stream de bytes de salida
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // producto -*> bytes[] -> outputStream -> producto_xxx.dat
        objectOutputStream.writeObject(producto); // Manda el objeto `producto` por la tubería

        objectOutputStream.close();

        outputStream.close();

        scanner.close();

    }

}
