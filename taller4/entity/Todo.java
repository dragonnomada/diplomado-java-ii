package entity;

import java.sql.Timestamp;

public class Todo {

    private int id;
    private String titulo;
    private boolean completado;
    private Timestamp creado;
    private Timestamp modificado;

    public Todo(int id, String titulo, boolean completado, Timestamp creado, Timestamp modificado) {
        this.id = id;
        this.titulo = titulo;
        this.completado = completado;
        this.creado = creado;
        this.modificado = modificado;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isCompletado() {
        return completado;
    }

    public Timestamp getCreado() {
        return creado;
    }

    public Timestamp getModificado() {
        return modificado;
    }
}
