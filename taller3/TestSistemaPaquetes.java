import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class TestSistemaPaquetes {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException, SQLException
    {
        String driver = "com.mysql.cj.jdbc.Driver";

        Class.forName(driver).getConstructor().newInstance();
        System.out.println("Driver cargado exitosamente");

        String url = "jdbc:mysql://3.144.219.217:3306/";
        String dbName = "inventario_abs";
        String user = "ipn";
        String password = "CIC_JavaII2022";

        Connection conn = DriverManager.getConnection(url + dbName, user, password);
        System.out.println("Conectado a la BD exitosamente");

        Scanner scanner = new Scanner(System.in);

        SistemaPaquetes sistemaPaquetes = new SistemaPaquetes(conn, scanner);

        sistemaPaquetes.abrirMenu();

        scanner.close();
        conn.close();

    }

}
