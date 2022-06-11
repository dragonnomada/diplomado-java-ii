package com.example.fx_app6;

public class Todo {

    private boolean completado;
    private String titulo;
    private String fechaCreado;
    private String fechaCompletado;

    public Todo(boolean completado, String titulo, String fechaCreado, String fechaCompletado) {
        this.completado = completado;
        this.titulo = titulo;
        this.fechaCreado = fechaCreado;
        this.fechaCompletado = fechaCompletado;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(String fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public String getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(String fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "completado=" + completado +
                ", titulo='" + titulo + '\'' +
                ", fechaCreado='" + fechaCreado + '\'' +
                ", fechaCompletado='" + fechaCompletado + '\'' +
                '}';
    }
}
