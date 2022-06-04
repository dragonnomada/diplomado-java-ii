import java.rmi.RemoteException;

public class LocalUserService implements UserService {
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
}
