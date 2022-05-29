package model.impl;

import entity.Todo;
import model.IExtraccionTodos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TodoFakeService implements IExtraccionTodos {
    @Override
    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>();

        todos.add(
                new Todo(
                    1,
                    "Prueba 1",
                    true,
                    Timestamp.valueOf("2022-08-01 15:55:01"),
                    Timestamp.valueOf("2022-08-01 16:04:23")
                )
        );

        todos.add(
                new Todo(
                        2,
                        "Prueba 2",
                        true,
                        Timestamp.valueOf("2022-08-02 15:55:01"),
                        Timestamp.valueOf("2022-08-03 16:04:23")
                )
        );

        return todos;
    }
}
