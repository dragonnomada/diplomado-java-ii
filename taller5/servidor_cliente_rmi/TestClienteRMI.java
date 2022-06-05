package servidor_cliente_rmi;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;

public class TestClienteRMI {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        UserService userService = (UserService) java.rmi.Naming.lookup("rmi://127.0.0.1:3333/UserServiceRMI");

        if (userService.isValid("batman", "robin")) {
            System.out.println(userService.getUserId("batman"));
        }

        byte[] data = userService.loadFile("C:\\test\\datos.txt");

        System.out.println(Arrays.toString(data));

    }

}
