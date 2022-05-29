package test;

import controller.TodoController;
import model.impl.TodoFakeService;
import model.impl.TodoService;
import view.impl.TodoUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.TimerTask;

public class TestTodoApp {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        TodoController todoController = new TodoController(); // <- extractor + visualizador

        TodoService todoService = new TodoService(); // -> IExtraccionTodos (extractor)
        //TodoFakeService todoService2 = new TodoFakeService(); // -> IExtraccionTodos (extractor)

        TodoUI todoUI = new TodoUI(); // -> IVisualizadorTodos (visualizador)

        todoController.setExtractor(todoService);
        //todoController.setExtractor(todoService2);
        todoController.setVisualizador(todoUI);

        // Conectar el capturador y el visualizador

        todoController.transaccionRefrescarTodos();

        Timer timer = new Timer(20000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                todoController.transaccionRefrescarTodos();
            }
        });

        timer.start();

    }

}
