import java.sql.*;
import java.util.Scanner;

public class SistemaPaquetes {

    private Connection conn;
    private Scanner scanner;

    public SistemaPaquetes(Connection conn, Scanner scanner) {
        this.conn = conn;
        this.scanner = scanner;

        this.instalarTablas();
    }

    private void instalarTablas() {
        instalarTablaPaquete();
        // TODO: Instalar demás tablas
    }

    private void instalarTablaPaquete() {
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(
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
        } catch (SQLException e) {
            System.out.println("Hay un error en la sintaxis para crear la tabla Paquete");
            return;
        }

        boolean resultado;
        try {
            resultado = statement.execute();
        } catch (SQLException e) {
            System.out.println("Falló la creación de la tabla Paquete: " + e.getMessage());
            return;
        }

        if (resultado) {
            System.out.println("Se instaló la tabla Paquete");
        } else {
            System.out.println("No se pudo crear la tabla Paquete");
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

    private String solicitarSku() {
        System.out.print("SKU: ");
        String sku = scanner.nextLine();
        return sku;
    }

    public void insertarPaquete(String sku) {
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement("INSERT INTO Paquete (sku) VALUES (?)");
        } catch (SQLException e) {
            System.out.println("Hay un error en la sintaxis al insertar el paquete");
            return;
        }
        try {
            statement.setString(1, sku); // Reemplazo de parámetros
        } catch (SQLException e) {
            System.out.println("No se puede insertar el parámetro sku");
            return;
        }
        try {
            statement.execute(); // excute -> INSERT/CREATE | executeUpdate -> UPDATE/DELETE | executeQuery -> SELECT
        } catch (SQLException e) {
            System.out.println("El paquete ya existe");
            //System.out.println("Error al ejecutar la consulta: " + e.getMessage());
            return;
        }
        System.out.printf("El paquete con SKU: %s fue insertado.\n", sku);
    }

    public void registrarPaquete() {
        String sku = solicitarSku(); // String solicitarSku()
        insertarPaquete(sku); // void insertarPaquete(String sku)
        regresarAlMenu();
    }

    private String solicitarGuia() {
        System.out.print("GUIA: ");
        String guia = scanner.nextLine();
        return guia;
    }

    public Paquete buscarPaquetePorSku(String sku) {
        PreparedStatement statement;

        try {
            statement = conn.prepareStatement("SELECT * FROM Paquete WHERE Sku=? LIMIT 1");
        } catch (SQLException e) {
            System.out.println("Hay un error en la sintaxis al buscar un producto por sku");
            return null;
        }

        try {
            statement.setString(1, sku);
        } catch (SQLException e) {
            System.out.println("No se puede ajustar el parámetro sku al buscar un producto por sku");
            return null;
        }

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Falló la busqueda por sku");
            return null;
        }

        try {
            if (resultSet.next()) {
                int id = resultSet.getInt("PaqueteID"); // resultSet.getInt(1)
                String guia = resultSet.getString("Guia"); // resultSet.getString(3)
                Boolean activo = resultSet.getBoolean("Activo"); // resultSet.getBoolean(4)
                Timestamp createAt = resultSet.getTimestamp("CreateAt"); // resultSet.getBoolean(5)
                Timestamp updateAt = resultSet.getTimestamp("UpdateAt"); // resultSet.getBoolean(6)

                Paquete paquete = new Paquete(id, sku, guia, activo, createAt, updateAt);

                System.out.printf("Se encontró el paquete con SKU: %s\n", sku);

                return paquete;
            } else {
                System.out.printf("No se encontró ningún producto con el SKU: %s\n", sku);
                return null;
            }
        } catch (SQLException e) {
            System.out.printf("No se encontró ningún producto con el SKU: %s [CON ERROR]\n", sku);
            return null;
        }
    }

    public void actualizarPaquete(Paquete paquete) {
        paquete.setUpdateAt(new Timestamp(0));

        // PreparedStatement statement = conn.prepareStatement("UPDATE Paquete SET guia=?, updateAt=? WHERE id=?");
    }

    public void asignarGuia() {
        String sku = solicitarSku();
        String guia = solicitarGuia(); // String solicitarGuia()
        Paquete paquete = buscarPaquetePorSku(sku); // Paquete buscarPaquetePorSku(String sku)
        // Paquete { int id, String sku, String guia, boolean activo, Timestamp createAt, Timestamp updateAt }
        paquete.setGuia(guia);
        actualizarPaquete(paquete); // Paquete actualizarPaquete(Paquete paquete)
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
