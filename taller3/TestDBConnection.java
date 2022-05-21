import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver).getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("La clase del drive no existe: " + e.getMessage());
            return;
        } catch (InvocationTargetException e) {
            System.out.println("La invocación falló: " + e.getMessage());
            return;
        } catch (InstantiationException e) {
            System.out.println("La instancia falló: " + e.getMessage());
            return;
        } catch (IllegalAccessException e) {
            System.out.println("Acceso ilegal: " + e.getMessage());
            return;
        } catch (NoSuchMethodException e) {
            System.out.println("El método no existe: " + e.getMessage());
            return;
        }

        System.out.println("Driver cargado exitosamente");

        String url = "jdbc:mysql://3.144.219.217:3306/";
        String dbName = "inventario_abs";
        String user = "ipn";
        String password = "CIC_JavaII2022";

        Connection conn;

        try {
            conn = DriverManager.getConnection(url + dbName, user, password);
        }  catch (SQLException e) {
            System.out.println("Falló SQL: " + e.getMessage());
            return;
        }

        System.out.println("Conectado a la BD exitosamente");

        // TODO: Usar la base de datos

        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Falló SQL: " + e.getMessage());
            return;
        }

        System.out.println("La base de datos ha sido cerrada exitosamente");

    }

}
