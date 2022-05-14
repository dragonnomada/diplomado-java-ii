import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class T203_App extends JFrame {
    private JTextArea textArea1;
    private JButton guardarButton;
    private JButton abrirButton;
    private JPanel panel1;

    public T203_App() {
        super();
        super.add(panel1);
        super.setTitle("Taller 203");
        super.setSize(500, 500);
        super.setLocation(710, 290);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);

        abrirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("C:\\test"));
                int result = chooser.showDialog(guardarButton, "Guardar");
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();

                    Scanner scanner;

                    try {
                        scanner = new Scanner(file);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel1, "No se pudo abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    textArea1.setText("");
                    while(scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        textArea1.setText(textArea1.getText() + line + "\n");
                    }

                    scanner.close();

                } else {
                    JOptionPane.showMessageDialog(panel1, "No se eligió ningún archivo");
                }
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenido = textArea1.getText();
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("C:\\test"));
                int result = chooser.showDialog(guardarButton, "Guardar");
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    FileWriter writer;
                    try {
                        writer = new FileWriter(file);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel1, "No se pudo abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                        writer.write(contenido);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel1, "No se pudo escribir el contenido", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        writer.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel1, "No se pudo guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    JOptionPane.showMessageDialog(panel1, "Archivo guardado");

                } else {
                    JOptionPane.showMessageDialog(panel1, "No se eligió ningún archivo");
                }

            }
        });
    }

    public static void main(String[] args) {
        new T203_App();
    }

}
