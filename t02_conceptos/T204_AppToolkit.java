package t02_conceptos;

import javax.swing.*;

public class T204_AppToolkit {
    private JPanel panel1;
    private JTree tree1;
    private JTabbedPane tabbedPane1;
    private JCheckBox checkBox1;
    private JComboBox comboBox1;
    private JList list1;
    private JTable table1;
    private JProgressBar progressBar1;
    private JButton abrirButton;
    private JButton guardarButton;
    private JButton exportarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button4;
    private JButton button5;
    private JLabel labelAcercaDeTitulo;

    public static void main(String[] args) {

        JFrame frame = new JFrame(); // ventana

        T204_AppToolkit app = new T204_AppToolkit();

        frame.add(app.panel1); // añadimos el panel principal a la venta

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
