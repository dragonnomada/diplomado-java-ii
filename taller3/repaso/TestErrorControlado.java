package repaso;

public class TestErrorControlado {

    public static void main(String[] args) {
        App app = new App();

        double resultado;

        try {
            resultado = app.dividir(5, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(resultado);
    }

}
