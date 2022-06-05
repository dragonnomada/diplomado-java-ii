package servidor_cliente_rmi;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LocalUserService extends UnicastRemoteObject implements UserService {

    protected LocalUserService() throws RemoteException {
    }

    @Override
    public boolean isValid(String username, String password) throws RemoteException {
        // TODO: Validar el usuario y la contraseña
        if (username.equals("batman") && password.equals("robin")) {
            return true;
        }
        return false;
    }

    @Override
    public int getUserId(String username) throws RemoteException {
        if (username.equals("batman")) {
            return 123;
        }
        throw new RuntimeException("El usuario no existe");
    }

    @Override
    public byte[] loadFile(String ruta) throws RemoteException {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            throw new RemoteException(e.getMessage());
        }

        byte[] data;

        try {
            data = inputStream.readAllBytes();
        } catch (IOException e) {
            throw new RemoteException(e.getMessage());
        }

        return data;
    }
}
