package t02_conceptos;

import javax.swing.*;

public class AppHello extends JFrame {
    private JPanel panel1;
    private JButton pulsameButton;

    public AppHello() {
        super(); // ~ JFrame frame = new JFrame()
        super.add(panel1); // ~ frame.add(panel1)
    }

    public static void main(String[] args) {
        AppHello app = new AppHello();

        app.setTitle("App - Hola Mundo");
        app.setSize(500, 500);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
