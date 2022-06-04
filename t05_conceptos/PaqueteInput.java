import java.io.Serializable;
import java.util.Scanner;

public class PaqueteInput implements Serializable {

    private int userId;
    private String username;
    private String password;
    private String message;

    public PaqueteInput(int userId, String username, String password, String message) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.message = message;
    }

    public PaqueteInput(Scanner scanner) {
        System.out.println("Capturar Datos del Paquete al Servidor");
        System.out.println("---------------------------------------------");
        System.out.print("ID: ");
        this.userId = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nombre de Usuario: ");
        this.username = scanner.nextLine();
        System.out.print("Contraseña: ");
        this.password = scanner.nextLine();
        System.out.print("Mensaje: ");
        this.message = scanner.nextLine();
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PaqueteInput{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
