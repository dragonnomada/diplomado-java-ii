package com.example.javafxdemo;

import java.util.ArrayList;
import java.util.List;

public class HelloRepository {

    private final static HelloRepository instance = new HelloRepository();

    public static HelloRepository getInstance() {
        return instance;
    }

    private List<HelloRepositoryListener> listeners = new ArrayList<>();

    public void subscribe(HelloRepositoryListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void unsubscribe(HelloRepositoryListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    public void update() {
        for (HelloRepositoryListener listener : listeners) {
            listener.onUpdate();
        }
    }

    private String title = "Hello world";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        update();
    }
}
