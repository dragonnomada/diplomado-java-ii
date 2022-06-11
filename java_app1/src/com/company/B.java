package com.company;

public class B implements StoreNumberActionListener {

    @Override
    public void onUpdate(Store<Integer> store, Integer count) {
        System.out.printf("Soy B y el contador se actualizó a: %d\n", count);
    }

}
