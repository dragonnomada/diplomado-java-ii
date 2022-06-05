import java.io.*;

public class TestObjectOutputStream {

    public static void main(String[] args) throws IOException {

        Coordenada coordenada = new Coordenada(98.123445, -115.4567321);

        OutputStream outputStream = new FileOutputStream("C:\\test\\coordenada.obj");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(coordenada);
        objectOutputStream.close();

        outputStream.close();

    }

}
