package entities;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int existencias; // 0

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        existencias = 0;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public boolean hasExistencias() {
        return existencias > 0;
    }

    public boolean isEmpty() {
        return existencias == 0;
    }

    public void setExistencias(int existencias) {
        if (existencias > 0) {
            this.existencias = existencias;
        } else {
            // TODO: Provocar error de existencias negativas
        }
    }

    public void aumentarExistencia() {
        existencias++;
    }

    public void quitarExistencia() {
        existencias--;
        if (existencias < 0) {
            existencias = 0;
        } else {
            // TODO: Provocar error de existencias negativas
        }
    }

    public void aumentarExistencia(int unidades) {
        existencias += unidades;
    }

    public void quitarExistencia(int unidades) {
        existencias -= unidades;
        if (existencias < 0) {
            existencias = 0;
        } else {
            // TODO: Provocar error de existencias negativas
        }
    }

    @Override
    public String toString() {
        return String.format("[%3d] %-20s $%8.2f (%3d)", id, nombre, precio, existencias);
    }

    public Producto copy() {
        Producto productoCopia = new Producto(id, nombre, precio);
        productoCopia.setExistencias(existencias);
        return productoCopia;
    }

}
