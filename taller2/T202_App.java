import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class T202_App {
    private JTextField textField1;
    private JPanel panel1;
    private JButton calcularButton;

    private JFrame frame;

    public T202_App() {
        frame = new JFrame();

        frame.add(panel1);

        frame.setTitle("Taller 202 - Calcular Cuadrado");
        frame.setSize(500, 500);
        frame.setLocation(710, 290);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();

                double valor;

                try {
                    valor = Double.parseDouble(texto);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(textField1,
                            error.toString(),
                            "No pudo convertir el valor",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double valor2 = valor * valor;

                String mensaje = String.format("El valor al cuadrado: %.2f", valor2);

                System.out.println(mensaje);

                JOptionPane.showMessageDialog(calcularButton, mensaje);
            }
        });
    }

    public static void main(String[] args) {
        new T202_App();
    }
}
