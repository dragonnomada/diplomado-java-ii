package com.company;

public class StoreNumber extends Store<Integer> {

    private static StoreNumber instance = new StoreNumber();

    public static StoreNumber getInstance() {
        return instance;
    }
}
