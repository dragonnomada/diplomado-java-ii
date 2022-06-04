import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

public class TestServerRMI {

    public static void main(String[] args) throws UnknownHostException, MalformedURLException, RemoteException {
        UserService userService = new LocalUserService();
        java.rmi.Naming.rebind("rmi://192.168.160.1:3333/UserServiceRMI", userService);
    }

}
