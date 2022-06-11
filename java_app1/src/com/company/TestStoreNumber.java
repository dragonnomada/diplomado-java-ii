package com.company;

public class TestStoreNumber {

    public static void main(String[] args) {

        StoreNumber.getInstance().setData(0);

        A a = new A(); // Store.getInstance().getData() | Store.getInstance().setData(T)

        B b = new B(); // StoreActionListener<T>

        StoreNumber.getInstance().subscribe(b);

        a.foo();
        a.foo();
        a.foo();

        StoreNumber.getInstance().unsubscribe(b);

        a.foo();
        a.foo();
        a.foo();

        StoreNumber.getInstance().subscribe(b);

        a.foo();
        a.foo();
        a.foo();

        StoreNumber.getInstance().unsubscribe(b);

    }

}
