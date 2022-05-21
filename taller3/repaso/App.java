package repaso;

public class App {

    void saludar() {
        System.out.println("Hola mundo");
    }

    // Método incontrolable:
    // El método advierte que es capaz de generar alguna excepción prevista o imprevista
    double dividir(double a, double b) throws Exception {
        if (b == 0) {
            throw new Exception("No se pueden dividir");
        }

        return a / b;
    }

}
