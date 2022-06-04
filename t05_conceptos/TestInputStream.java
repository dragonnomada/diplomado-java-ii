import java.io.*;
import java.util.Arrays;

public class TestInputStream {

    public static void main(String[] args) throws IOException {

        InputStream inputStream1 = new FileInputStream("C:\\test\\data.txt");

        byte[] bytes1 = inputStream1.readAllBytes();

        System.out.println(Arrays.toString(bytes1));

        inputStream1.close();

        String path = "C:\\test\\logo.jpg";

        File file = new File(path);

        InputStream inputStream2 = new FileInputStream(path);

        int chunkSize = 512;

        long totalChunks = (long) Math.floor(file.length() / chunkSize) + 1;

        System.out.printf("Se leerán %d chunks\n", totalChunks);

        for (int i = 0; i < totalChunks; i++) {
            byte[] chunk = inputStream2.readNBytes(chunkSize);
            System.out.println(Arrays.toString(chunk));
            // TODO: Enviar/Almacenar el chunk
            OutputStream outputStream = new FileOutputStream(String.format("%s.part%d", path, i));
            outputStream.write(chunk);
            outputStream.close();
        }

        inputStream2.close();

    }

}
