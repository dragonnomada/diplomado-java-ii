package t01_conceptos;

public interface ITodoList {

    boolean agregarTodo(String titulo);

    void completarTodo(int indice);

    void incompletarTodo(int indice);

    String mostrarTodos();

}
