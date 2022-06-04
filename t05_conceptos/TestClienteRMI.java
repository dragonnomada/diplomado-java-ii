import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TestClienteRMI {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        UserService userService = (UserService) java.rmi.Naming.lookup("rmi://0.0.0.0:3333/UserServiceRMI");

        if (userService.isValid("batman", "robin")) {
            System.out.println(userService.getUserId("batman"));
        }

    }

}
