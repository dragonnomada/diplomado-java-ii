package servidor_cliente_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {

    boolean isValid(String username, String password) throws RemoteException;

    int getUserId(String username) throws RemoteException;

    byte[] loadFile(String ruta) throws RemoteException;

}
