package model.impl;

import entity.Todo;
import model.IExtraccionTodos;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// TodoService todoService = new TodoService(...);
public class TodoService implements IExtraccionTodos {

    private Connection connection;

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbname = "ipn";
    private String user = "root";
    private String password = "password";

    public TodoService() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(driver).getConstructor().newInstance();
        connection = DriverManager.getConnection(url + dbname, user, password);
    }

    @Override
    public List<Todo> getTodos() {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("select * from todos");
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(); // ???
        }

        ResultSet resultSet;

        try {
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(); // ???
        }

        List<Todo> todos = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Todo todo = new Todo(
                        resultSet.getInt("id"),
                        resultSet.getString("titulo"),
                        resultSet.getBoolean("completado"),
                        resultSet.getTimestamp("creado"),
                        resultSet.getTimestamp("modificado")
                );
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return todos; // ???
        }

        return todos;
    }
}
