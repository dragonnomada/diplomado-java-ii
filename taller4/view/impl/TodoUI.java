package view.impl;

import entity.Todo;
import view.IVisualizacionTodos;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// TODO: Implementar la interfaz ICapturarTodo
// TODO: Llamar a la traccionAgregarTodo() cuándo se pulse clic en agregarButton

// TodoUI todoUI = new TodoUI(...)
public class TodoUI implements IVisualizacionTodos {
    private JTextField textField1;
    private JButton agregarButton;
    private JPanel panelTodos;
    private JPanel panel1;
    private JFrame frame;

    public TodoUI() {
        frame = new JFrame();
        frame.add(panel1);
        frame.setTitle("Todos App");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void mostrarTodos(List<Todo> todos) {
        panelTodos.removeAll();
        for (Todo todo : todos) {
            JPanel panelTodo = new JPanel();
            panelTodo.setLayout(new BorderLayout());
            JCheckBox checkBoxCompletado = new JCheckBox();
            checkBoxCompletado.setSelected(todo.isCompletado());
            JLabel labelTitulo = new JLabel(todo.getTitulo());
            JLabel labelCreado = new JLabel(todo.getCreado().toString());
            JLabel labelModificado;
            if (todo.getModificado() != null) {
                labelModificado = new JLabel(todo.getModificado().toString());
            } else {
                labelModificado = new JLabel("SIN MODIFICACIÓN");
            }
            panelTodo.add(checkBoxCompletado, BorderLayout.LINE_START);
            panelTodo.add(labelTitulo, BorderLayout.CENTER);
            panelTodo.add(labelCreado, BorderLayout.PAGE_END);
            panelTodo.add(labelModificado, BorderLayout.PAGE_START);
            this.panelTodos.add(panelTodo);
        }
        panelTodos.updateUI();
    }
}
