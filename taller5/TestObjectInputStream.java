import java.io.*;

public class TestObjectInputStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        InputStream inputStream = new FileInputStream("C:\\test\\coordenada.obj");

        // byte[] bytes = inputStream.readAllBytes(); ???

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Coordenada coordenada = (Coordenada) objectInputStream.readObject();

        System.out.println(coordenada);

        objectInputStream.close();

        inputStream.close();

    }

}
