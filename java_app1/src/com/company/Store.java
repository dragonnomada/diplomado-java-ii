package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Store<T> {

    private List<StoreActionListener<T>> listeners = new ArrayList<>();

    public void subscribe(StoreActionListener<T> listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void unsubscribe(StoreActionListener<T> listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        for (StoreActionListener<T> listener : listeners) {
            listener.onUpdate(this, data);
        }
    }

}
