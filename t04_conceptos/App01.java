import javax.swing.*;

public class App01 {

    private JButton pulsameButton;
    private JPanel panel1;

    private JFrame frame;

    public App01() {
        construirFrame();
    }

    private void construirFrame() {
        frame = new JFrame();

        frame.add(panel1);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        App01 app = new App01();
    }

}
