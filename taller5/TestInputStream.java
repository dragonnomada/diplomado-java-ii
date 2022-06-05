import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class TestInputStream {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream("C:\\openssl\\bin\\libeay32.dll");

        int b = inputStream.read();

        System.out.printf("0: %d\n", b);

        byte[] nbytes = inputStream.readNBytes(100);

        System.out.println(Arrays.toString(nbytes));

        byte[] others = inputStream.readAllBytes();

        //System.out.println(Arrays.toString(others));

        inputStream.close();

    }

}
