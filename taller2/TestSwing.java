import javax.swing.*;

class TestSwing {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();

        JButton button = new JButton();

        button.setText("Pulsame");

        panel.add(button);

        frame.add(panel);

        frame.setTitle("Test Swing");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}
