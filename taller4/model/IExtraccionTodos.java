package model;

import entity.Todo;

import java.util.List;

// IExtraccionTodos extractor = todoService
public interface IExtraccionTodos {

    List<Todo> getTodos();

}
