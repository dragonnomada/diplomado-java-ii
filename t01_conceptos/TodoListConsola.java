package t01_conceptos;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoListConsola implements ITodoList {

    ArrayList<String> titulos = new ArrayList<>();
    ArrayList<Boolean> completados = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {

        System.out.print(mostrarTodos());
        System.out.println("--------------------");
        System.out.println("Selecciona una opción:");
        System.out.println("1. Agregar TODO");
        System.out.println("2. Completar TODO");
        System.out.println("3. Incompletar TODO");
        System.out.println("4. Salir");

        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                agregarTodo(capturarTodoTitulo());
                break;
            case 2:
                completarTodo(capturarIndice());
                break;
            case 3:
                incompletarTodo(capturarIndice());
                break;
            case 4:
                System.out.println("Fin del programa");
                scanner.close();
                return; // Regresa (la función termina aquí)
            default:
                System.out.println("Opción no válida");
                break;
        }

        mostrarMenu(); // RECURSIVIDAD
    }

    public int capturarIndice() {
        System.out.print("Índice: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        return indice;
    }

    public String capturarTodoTitulo() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        return titulo;
    }

    @Override
    public boolean agregarTodo(String titulo) {
        titulos.add(titulo);
        completados.add(false);
        return true;
    }

    @Override
    public void completarTodo(int indice) {
        completados.set(indice, true);
    }

    @Override
    public void incompletarTodo(int indice) {
        completados.set(indice, false);
    }

    @Override
    public String mostrarTodos() {
        String text = "";
        for (int i = 0; i < titulos.size(); i++) {
            String titulo = titulos.get(i);
            boolean completado = completados.get(i);
            text += String.format("%d. [%B] %s\n", i, completado, titulo);
        }
        return text;
    }

    public static void main(String[] args) {

        TodoListConsola todoListConsola = new TodoListConsola();

        todoListConsola.mostrarMenu();

    }

}
