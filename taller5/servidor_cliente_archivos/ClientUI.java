package servidor_cliente_archivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ClientUI {
    private JTextField textFieldHost;
    private JButton enviarArchivoButton;
    private JSpinner spinner1;
    private JPanel panel1;

    private JFrame frame;
    private Socket server;

    public ClientUI() {
        inicializarVentana();

        spinner1.setValue(5001);

        enviarArchivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String host = textFieldHost.getText();
                int port = (int)spinner1.getValue();

                enviarArchivoButton.setEnabled(false);

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int s = fileChooser.showOpenDialog(frame);

                if (s == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    InputStream fileInputStream = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error al abrir el archivo", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    byte[] datos = new byte[0];
                    try {
                        datos = fileInputStream.readAllBytes();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error al leer el archivo", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        fileInputStream.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error al cerrar el archivo", JOptionPane.ERROR_MESSAGE);
                    }

                    TransferFile archivo = new TransferFile(file.getName(), "", datos);

                    try {
                        server = new Socket(host, port);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error al conectarse al servidor", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        OutputStream outputStream = server.getOutputStream();
                        ObjectOutputStream objectOuputStream = new ObjectOutputStream(outputStream);
                        objectOuputStream.writeObject(archivo);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error al enviar el archivo al servidor", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        InputStream inputStream = server.getInputStream();
                        int b = inputStream.read();
                        System.out.println(b);
                        /*ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                        Object object = objectInputStream.readObject();
                        System.out.println(object);*/
                        boolean guardado = b == 1;

                        if (guardado) {
                            JOptionPane.showMessageDialog(frame, "Archivo guardado en el servidor", "Archivo enviado al servidor", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "No se pudo guardar el archivo en el servidor", "Error al enviar el archivo al servidor", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error al recibir la respuesta del servidor", JOptionPane.ERROR_MESSAGE);
                    }

                    try {
                        server.close();
                        enviarArchivoButton.setEnabled(true);
                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(frame, "No se pudo desconectar del servidor", "Error al enviar el archivo al servidor", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                }
            }
        });
    }

    private void inicializarVentana() {
        frame = new JFrame();
        frame.add(panel1);
        frame.setSize(400, 400);
        frame.setTitle("Servidor de Archivos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void lanzarVentana() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ClientUI clientUI = new ClientUI();

        clientUI.lanzarVentana();
    }
}
