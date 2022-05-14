package t02_conceptos;

import javax.swing.*;

/**
 *
 * Define una clase AppLogin(subclase) que deriva de JFrame(superclase)
 *
 * AppLogin es esencialmente una venta (JFrame) pero extiende más definiciones.
 * Enlaza los elementos definidos en el formulario visual (panel1, textFieldUsuario, passwordFieldContraseña, ...)
 *
 * Definimos un constructor, para que cada que se cree un AppLogin (una ventana login)
 * determinemos el estado inicial que tendrá la venta. Por ejemplo, el tamaño, si estará visible, etc.
 * También conectaremos a la venta el componente principal `panel1` que representa el panel con toda
 * la aplicación diseñada en el formulario visual.
 *
 * NOTA: En el constructor no olvidamos llamar al constructor de la superclase (super -> JFrame)
 *
 * 1. Construimos la ventana: super() ~ new JFrame()
 * 2. Agregamos el `panel1` a la venta (de la superclase): super.add(...) ~ frame.add(...)
 *
 *
 */

public class AppLogin extends JFrame { // Heredamos AppLogin de JFrame -> AppLogin es una ventana
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldContraseña;
    private JButton ingresarButton;
    private JPanel panel1;

    public AppLogin() {
        super(); // El constructor de la superclase (super -> JFrame)
        // ¿Quién es nosotros? ¿Quién es la instancia nosotros? (this -> AppLogin)
        super.add(panel1);
    }

    public static void main(String[] args) {
        AppLogin app = new AppLogin(); // Al instanciar llamamos al constructor -> public AppLogin()

        app.setTitle("App Login");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500, 500);
        app.setVisible(true);
    }
}
