import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestSocketB {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket server = new Socket("127.0.0.1", 4444);

        Scanner scanner = new Scanner(System.in);

        PaqueteInput paqueteInput = new PaqueteInput(scanner);
        OutputStream outputStream = server.getOutputStream(); // Le queremos escribir cosas al servidor
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(paqueteInput);
        //objectOutputStream.close();

        InputStream inputStream = server.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        PaqueteOutput paqueteOutput = (PaqueteOutput) objectInputStream.readObject();
        //objectInputStream.close();

        System.out.println(paqueteOutput);

        scanner.close();

    }

}
