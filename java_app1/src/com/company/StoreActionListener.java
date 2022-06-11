package com.company;

public interface StoreActionListener<T> {

    void onUpdate(Store<T> store, T data);

}
