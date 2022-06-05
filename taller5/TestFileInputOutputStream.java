import java.io.*;

public class TestFileInputOutputStream {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream("C:\\test\\logo.jpg");
        OutputStream outputStream = new FileOutputStream("C:\\backup\\logo.bak.jpg");

        byte[] bytes = inputStream.readAllBytes();

        outputStream.write(bytes);

        inputStream.close();
        outputStream.close();

    }

}
