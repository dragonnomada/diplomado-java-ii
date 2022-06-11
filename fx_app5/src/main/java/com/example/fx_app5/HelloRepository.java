package com.example.fx_app5;

import java.util.ArrayList;
import java.util.List;

public class HelloRepository {

    // El repositorio tendrá una instancia única para todas las ventanas (controladores)
    private final static HelloRepository instance = new HelloRepository();

    public static HelloRepository getInstance() {
        return instance;
    }

    // El repositorio debería retener a todos los que quieran escuchar los cambios
    // mediante un sistema de suscripción/desuscripción
    private List<IHelloRepositoryListener> listeners = new ArrayList<>();

    public void suscribe(IHelloRepositoryListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void unsuscribe(IHelloRepositoryListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    private String nombre;
    private double precio;

    public String getNombre() {
        return nombre;
    }

    public void emitUpdateNombre() {
        for (IHelloRepositoryListener listener : listeners) {
            listener.onUpdateNombre(nombre);
        }
    }

    public void emitUpdatePrecio() {
        for (IHelloRepositoryListener listener : listeners) {
            listener.onUpdatePrecio(precio);
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        // TODO: Guardar el nuevo nombre de forma permanente
        // TODO: Notificar que el repositorio fue actualizado
        emitUpdateNombre();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        // TODO: Guardar el nuevo nombre de forma permanente
        // TODO: Notificar que el repositorio fue actualizado
        emitUpdatePrecio();
    }
}
