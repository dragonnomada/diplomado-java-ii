package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductosDB implements IAgregarProductoModel {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbname = "ipn";
    private String user = "root";
    private String password = "password";

    private Connection connection = null;

    public ProductosDB() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(driver).getConstructor().newInstance();
        connection = DriverManager.getConnection(url + dbname, user, password);
    }

    @Override
    public boolean agregarProducto(String nombre, String descripcion, double precio, int existencias) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into productos (nombre, descripcion, precio, existencias) values (?, ?, ?, ?)");
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.setDouble(3, precio);
            statement.setInt(4, existencias);
            if (statement.execute()) { // execute() -> true si falla
                System.out.println("Surgió un error en la ejecución");
                statement.close();
                return false;
            } else {
                System.out.println("Todo salió bien en la ejecución");
                statement.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
