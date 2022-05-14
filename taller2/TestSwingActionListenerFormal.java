import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControladorBoton implements ActionListener {

    private int contador = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.printf("Contador: %d\n", contador++);
    }
}

class TestSwingActionListenerFormal {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton button = new JButton("Pulsame");

        ControladorBoton controlador1 = new ControladorBoton(); // Crea un controlador

        button.addActionListener(controlador1); // Determinar llamar al controlador cada que el botón se pulse

        panel.add(button);
        frame.add(panel);

        frame.setTitle("Test Swing");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}