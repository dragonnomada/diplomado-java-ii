import entities.Producto;
import entities.VentaConProductos;

public class C02_TestVentaConProductos {

    public static void main(String[] args) {

        Producto p1 = new Producto(1, "Coca Cola", 18.55);
        Producto p2 = new Producto(2, "Galletas Marías", 6.78);
        Producto p3 = new Producto(3, "Gansito", 12.78);
        Producto p4 = new Producto(4, "Pepsi", 14.51);
        Producto p5 = new Producto(5, "Frutsi", 3.56);
        Producto p6 = new Producto(6, "Choco Roll", 9.90);

        p1.setExistencias(100);
        p2.setExistencias(20);
        p3.setExistencias(15);
        p4.setExistencias(4);
        p5.setExistencias(2);
        p6.setExistencias(1);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println("------------------------------");

        VentaConProductos v1 = new VentaConProductos(123);
        VentaConProductos v2 = new VentaConProductos(456);
        VentaConProductos v3 = new VentaConProductos(999);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println("------------------------------");

        v1.agregarProducto(p1);
        v1.agregarProducto(p2, 5);
        v1.agregarProducto(p3, 2);
        v1.agregarProducto(p4, 100);

        v2.agregarProducto(p1, 200);
        v2.agregarProducto(p4, 3);
        v2.agregarProducto(p5, 1);

        v3.agregarProducto(p3, 5);
        v3.agregarProducto(p4, 5);
        v3.agregarProducto(p5, 5);
        v3.agregarProducto(p6, 5);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println("------------------------------");

        v1.setMontoPagado(150);
        v1.cerrarVenta();
        v2.setMontoPagado(2000);
        v2.cerrarVenta();
        v3.setMontoPagado(500);
        v3.cerrarVenta();

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println("------------------------------");

    }

}
