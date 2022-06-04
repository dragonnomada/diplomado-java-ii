import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestClienteFacturacion {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket server = new Socket("127.0.0.1", 5555);

        Scanner scanner = new Scanner(System.in);

        DatosFactura datosFactura = new DatosFactura("MNDA889903", "MXRJ547823", 1234.56, 234.56, 643.12);

        OutputStream outputStream = server.getOutputStream(); // Le queremos escribir cosas al servidor
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(datosFactura);

        InputStream inputStream = server.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Factura factura = (Factura) objectInputStream.readObject();

        System.out.println(factura);

        scanner.close();

    }

}
