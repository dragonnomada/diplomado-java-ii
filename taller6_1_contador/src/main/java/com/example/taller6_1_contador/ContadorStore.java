package com.example.taller6_1_contador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContadorStore {

    // 1. INSTANCIA ESTÁTICA
    private final static ContadorStore instance = new ContadorStore();
    public static ContadorStore getInstance() {
        return instance;
    }
    // INSTANCIA ESTÁTICA

    // 2. DATOS RETENIDOS
    private Contador contador = new Contador(0, new Date());
    // DATOS RETENIDOS

    // 3. GETTER / EXTRAER
    public int getValor() {
        return contador.getValor();
    }
    public Date getFechaModificado() {
        return contador.getFechaModificado();
    }
    // GETTER / EXTRAER

    // 4. ACTIONS / SETTERS
    public void incrementar() {
        contador.setValor(contador.getValor() + 1);
        contador.setFechaModificado(new Date());
        updateStore();
    }
    public void decrementar() {
        contador.setValor(contador.getValor() - 1);
        contador.setFechaModificado(new Date());
        updateStore();
    }
    public void reiniciar() {
        contador.setValor(0);
        contador.setFechaModificado(new Date());
        updateStore();
    }
    // ACTIONS / SETTERS

    // 5. LISTENERS
    private List<ContadorStoreActionListener> listeners = new ArrayList<>();
    public void suscribir(ContadorStoreActionListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }
    public void desuscribir(ContadorStoreActionListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }
    // NOTIFICAR A LOS listeners QUE EL store SE ACTUALIZÓ
    public void updateStore() {
        for (ContadorStoreActionListener listener : listeners) {
            listener.onUpdateContador(contador.getValor(), contador.getFechaModificado());
        }
    }
    // LISTENERS

}
