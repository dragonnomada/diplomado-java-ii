import entities.Venta;

import java.util.Locale;

public class C01_TestVenta {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Venta v1 = new Venta(123, 700);
        Venta v2 = new Venta(456, 56);
        Venta v3 = new Venta(999, 1234.56);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        if (!v1.cerrarVenta()) {
            System.out.println("No se puede cerrar la venta 1");
        }

        v2.setMontoPagado(100);
        if (!v2.cerrarVenta()) {
            System.out.println("No se puede cerrar la venta 2");
        }

        v3.setMontoPagado(1000);
        if (!v3.cerrarVenta()) {
            System.out.println("No se puede cerrar la venta 3");
        }

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        v1.setMontoPagado(1000);
        v1.cerrarVenta();

        v2.setMontoPagado(30);

        v3.setMontoPagado(1500);
        v3.cerrarVenta();

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

    }

}
