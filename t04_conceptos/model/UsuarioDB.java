package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class UsuarioDB implements ILoginModel {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbname = "ipn";
    private String user = "root";
    private String password = "password";

    private Connection connection = null;

    public UsuarioDB() {
        try {
            Class.forName(driver).getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url + dbname, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isValidUserAndPassword(String user, String password) throws SQLException {
        if (connection == null) {
            throw new SQLException("No hay conexión a la base de datos");
        }

        System.out.printf("USUARIO: <%s> CONTRASEÑA: <%s>\n", user, password);

        PreparedStatement statement = connection.prepareStatement("select * from usuario where usuario=? and contra=? ");

        statement.setString(1, user);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }
}
