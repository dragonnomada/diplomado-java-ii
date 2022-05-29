package controller;

import entity.Todo;
import model.IDepositarTodo;
import model.IExtraccionTodos;
import view.ICapturarTodo;
import view.IVisualizacionTodos;

import java.util.List;

// TodoController todoController = new TodoController();
// todoController.setExtractor(todoService) | todoController.setExtractor(todoFakeService) | ...
// todoController.setVisualizador(todoUI) | todoController.setVisualizador(todoCLI) | ...
public class TodoController {

    private IExtraccionTodos extractor;
    private IVisualizacionTodos visualizador;

    private ICapturarTodo capturador;
    private IDepositarTodo depositador;

    public void setExtractor(IExtraccionTodos extractor) {
        this.extractor = extractor;
    }

    public void setVisualizador(IVisualizacionTodos visualizador) {
        this.visualizador = visualizador;
    }

    public void setCapturador(ICapturarTodo capturador) {
        this.capturador = capturador;
    }

    public void setDepositador(IDepositarTodo depositador) {
        this.depositador = depositador;
    }

    public void transaccionRefrescarTodos() {
        List<Todo> todos = extractor.getTodos();
        visualizador.mostrarTodos(todos);
    }

    // TODO: Definir la tracción transaccionAgregarTodo()
}
