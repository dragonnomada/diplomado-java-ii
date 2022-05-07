import entities.IVendible;
import entities.Libro;
import entities.Playera;

public class D01_TestVendible {

    // vendible --> OBJETO INTERFAZ
    // Objeto que proviene de una clase que implementa la interfaz
    static double getImporteMasIva(IVendible vendible) {
        return vendible.getImporte() * 1.16;
    }

    static boolean pagar(IVendible[] vendibles) {
        double total = 0;
        for (IVendible vendible : vendibles) {
            if (vendible.getExistencias() > 0) {
                total += vendible.getImporte();
            }
        }
        if (total != 0) {
            // TODO: Pago
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Libro l1 = new Libro();
        Libro l2 = new Libro();
        Libro l3 = new Libro();
        Libro l4 = new Libro();

        Playera p1 = new Playera();
        Playera p2 = new Playera();
        Playera p3 = new Playera();
        Playera p4 = new Playera();
        Playera p6 = new Playera();

        System.out.println(getImporteMasIva(l1));
        System.out.println(getImporteMasIva(p1));
        System.out.println(getImporteMasIva(l2));
        System.out.println(getImporteMasIva(p4));

    }

}
