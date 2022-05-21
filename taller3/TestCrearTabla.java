import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class TestCrearTabla {

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

        // TODO: Usar la base de datos
        PreparedStatement statement = conn.prepareStatement(
                "create table if not exists prueba (" +
                        "id int not null auto_increment," +
                        "nombre varchar(255) not null," +
                        "create_at timestamp not null default now()," +
                        "primary key (id)" +
                ")"
        );

        int codigo = statement.executeUpdate();

        System.out.println(codigo);

        conn.close();
        System.out.println("La base de datos ha sido cerrada exitosamente");

    }

}
