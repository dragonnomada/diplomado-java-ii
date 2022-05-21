import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SistemaPaquetes {

    private Connection conn;
    private Scanner scanner;

    public SistemaPaquetes(Connection conn, Scanner scanner) throws SQLException {
        this.conn = conn;
        this.scanner = scanner;

        this.instalarTablas();
    }

    private void instalarTablas() throws SQLException {
        instalarTablaPaquete();
        // TODO: Instalar demás tablas
    }

    private void instalarTablaPaquete() throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(
                "CREATE TABLE IF NOT EXISTS Paquete (\n" +
                        "  PaqueteID int NOT NULL AUTO_INCREMENT,\n" +
                        "  Sku varchar(255) NOT NULL UNIQUE,\n" +
                        "  Guia varchar(255),\n" +
                        "  Activo bool,\n" +
                        "  CreateAt timestamp NOT NULL DEFAULT now(),\n" +
                        "  UpdateAt timestamp,\n" +
                        "  PRIMARY KEY (PaqueteID)\n" +
                        ")"
        );

        int resultado = preparedStatement.executeUpdate();

        if (resultado == 0) {
            System.out.println("Se instaló la tabla Paquete");
        } else {
            throw new SQLException("No se pudo crear la tabla Paquete");
        }
    }

    public void abrirMenu() {
        System.out.println("Menú de Paquetes");
        System.out.println("--------------------------------");
        System.out.println("1. Registrar Paquete");
        System.out.println("2. Asignar Guia");
        System.out.println("3. Ver Paquetes");
        System.out.println("4. Buscar Paquete");
        System.out.println("5. Activar/Desactivar Paquete");
        System.out.println("6. Ver Historial del Paquete");
        System.out.println("--------------------------------");
        System.out.println("7. Salir");
        System.out.println();

        seleccionarOpcion();
    }

    private void seleccionarOpcion() {

    }

}
