package servidor_cliente_rmi;

import java.lang.module.Configuration;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestServerRMI {

    public static void main(String[] args) throws UnknownHostException, MalformedURLException, RemoteException {

        UserService userService = new LocalUserService();
        Registry registry = LocateRegistry.createRegistry(3333); // Crear un registry en el puerto específico
        registry.rebind("UserServiceRMI", userService);

    }

}
