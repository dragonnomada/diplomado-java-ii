import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TestSwingActionListenerInformal {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton button = new JButton("Pulsame");

        button.addActionListener(new ActionListener() {

            private int contador = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.printf("Contador: %d\n", contador++);
            }

        }); // Determinar llamar al controlador cada que el botón se pulse

        panel.add(button);
        frame.add(panel);

        frame.setTitle("Test Swing");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
