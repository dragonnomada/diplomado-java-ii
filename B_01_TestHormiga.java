import entities.DireccionHomiga;
import entities.Hormiga;

public class B_01_TestHormiga {

    public static void main(String[] args) {

        Hormiga h1 = new Hormiga();
        Hormiga h2 = new Hormiga(123, 5);
        Hormiga h3 = new Hormiga(-999, 4, DireccionHomiga.SUR);

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println("------------------------");

        h1.mirarOeste();
        h2.mirarSur();
        h3.mirarEste();

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println("------------------------");

        h1.mover();
        h2.moverOeste();
        h3.moverNorte();

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println("------------------------");

        h1.mirarNorte();
        h1.mover(100);

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println("------------------------");

    }

}
