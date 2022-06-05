import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class TestOutputStream {

    public static void main(String[] args) throws IOException {

        OutputStream outputStream = new FileOutputStream("C:\\test\\archivo.txt"); // Recupera la tubería de salida

        outputStream.write(10); // Escribe el byte 10 (salto de línea en ascii)

        outputStream.write(new byte[] { 65, 67, 84, 97, -78 }); // Escribe los bytes 65, 67, 84, ...

        outputStream.close();

    }

}