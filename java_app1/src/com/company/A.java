package com.company;

public class A {

    public void foo() {
        int count = StoreNumber.getInstance().getData();
        StoreNumber.getInstance().setData(count + 1);
    }

}
