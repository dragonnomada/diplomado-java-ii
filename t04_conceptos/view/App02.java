package view;

import controller.LoginController;
import model.UsuarioDB;

import javax.swing.*;
import java.awt.*;

public class App02 implements ILoginView {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton aceptarButton;

    private JFrame frame;

    public App02() {
        construirVentana(500, 350);
    }

    public void construirVentana(int width, int height) {
        frame = new JFrame();
        frame.add(panel1);
        frame.setTitle("Iniciar Sesión");
        frame.setSize(width, height);
        int x = (int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - width) / 2);
        int y = (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - height) / 2);
        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        App02 view = new App02();

        UsuarioDB model = new UsuarioDB();

        LoginController controller = new LoginController(view, model);
    }

    @Override
    public JButton getSignInButton() {
        return this.aceptarButton;
    }

    @Override
    public String getUser() {
        return this.textField1.getText();
    }

    @Override
    public String getPassword() {
        return this.passwordField1.getText();
    }

    @Override
    public void showSuccessLogin() {
        JOptionPane.showMessageDialog(this.frame, "Ya puedes ingresar al sistema :D", "Inicio de sesión correcto", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showErrorLogin(String message) {
        JOptionPane.showMessageDialog(this.frame, message, "Error al iniciar sesión", JOptionPane.ERROR_MESSAGE);
    }
}
