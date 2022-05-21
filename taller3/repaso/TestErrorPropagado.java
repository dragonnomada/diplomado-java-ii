package repaso;

public class TestErrorPropagado {

    public static void main(String[] args) throws Exception {

        App app = new App();

        // El método dividir nos obliga a controlar la excepción
        // porque es un método incontrolable
        // Entonces tenemos dos alternativas para controlar la excepción:
        // 1. Propagar el error y olvidarnos de controlarlo
        //      (que se haga responsable el siguiente programador o el nivel de arriba)
        // 2. Colocar un try-catch que atienda la posible excepción
        double resultado = app.dividir(5, 2);

        System.out.println(resultado);

    }

}
