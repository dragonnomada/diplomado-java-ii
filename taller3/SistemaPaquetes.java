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
        System.out.print("Opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        seleccionarOpcion(opcion);
    }

    public void seleccionarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarPaquete();
                break;
            case 2:
                asignarGuia();
                break;
            case 3:
                verPaquetes();
                break;
            case 4:
                buscarPaquete();
                break;
            case 5:
                activarDesactivarPaquete();
                break;
            case 6:
                verHistorialPaquete();
                break;
            case 7:
                salir();
                break;
            default:
                seleccionNoValida();
                break;
        }
    }

    private void hacerPausa() {
        System.out.print("[Pula ENTER para continuar...]");
        scanner.nextLine();
    }

    private void regresarAlMenu() {
        hacerPausa();
        abrirMenu();
    }

    public void registrarPaquete() {
        String sku = solicitarSku(); // String solicitarSku()
        insertarPaquete(sku); // void insertarPaquete(String sku)
        regresarAlMenu();
    }

    public void asignarGuia() {
        String sku = solicitarSku();
        String guia = solicitarGuia(); // String solicitarGuia()
        Paquete paquete = buscarPaquetePorSku(sku); // Paquete buscarPaquetePorSku(String sku)
        // Paquete { int paqueteId, String sku, String guia, boolean activo, Date createAt, Date updateAt }
        regresarAlMenu();
    }

    public void verPaquetes() {
        // TODO: Implementar
        regresarAlMenu();
    }

    public void buscarPaquete() {
        // TODO: Implementar
        regresarAlMenu();
    }

    public void activarDesactivarPaquete() {
        // TODO: Implementar
        regresarAlMenu();
    }

    public void verHistorialPaquete() {
        // TODO: Implementar
        regresarAlMenu();
    }

    public void salir() {
        System.out.println("Gracias, fin del programa");
    }

    public void seleccionNoValida() {
        System.out.println("La opción no es válida");
        regresarAlMenu();
    }



}
