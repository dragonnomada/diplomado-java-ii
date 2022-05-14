import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestSwingTextField extends JFrame {
    private JTextField textField1;
    private JPanel panel1;
    private JButton calcularButton;

    public TestSwingTextField() {
        super();

        super.add(panel1);
        super.setTitle("Test Swing - TextField");
        super.setSize(500, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();
                double valor;

                try {
                    valor = Double.parseDouble(texto);
                    // continua aquí
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(textField1,
                            "Error: "+ error.toString(),
                            "Error al converir",
                            JOptionPane.ERROR_MESSAGE);
                    return; // termina el evento actionPerformed
                }

                // continua acá

                System.out.println(valor);
            }
        });
    }

    public static void main(String[] args) {
        new TestSwingTextField();

        /*String text = "hola mundo";

        String[] parts = text.split("");

        char[] partsChar = text.toCharArray();

        System.out.println(Arrays.toString(parts));
        System.out.println(Arrays.toString(partsChar));

        for (char c : partsChar) {
            System.out.println((int)c);
        }

        System.out.println((char)65);*/
    }

}
