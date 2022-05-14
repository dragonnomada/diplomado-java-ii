package t02_conceptos;

import javax.swing.*;

public class T205_AppDemo {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JTextField textField2;
    private JCheckBox checkBox1;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JTextField textField3;
    private JTextField textField4;

    public static void main(String[] args) {

        JFrame frame = new JFrame(); // Crea una venta

        T205_AppDemo app = new T205_AppDemo(); // Construye la App ligada al formulario

        frame.add(app.panel1); // Añade a la ventana el panel principal de la App

        // Configura la ventana:
        frame.setTitle("Mi App Demo :D");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
