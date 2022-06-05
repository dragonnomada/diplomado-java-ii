package servidor_cliente_archivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerUI {

    private JSpinner spinner1;
    private JButton iniciarButton;
    private JButton detenerButton;
    private JTextArea textArea1;
    private JPanel panel1;
    private JLabel labelConectado;

    private JFrame frame;

    private ServerSocket server;
    private Thread threadServer; // hilo que recibe los clientes del servidor
    private boolean isStarted = false;

    public ServerUI() {

        inicializarVentana();

        spinner1.setValue(5001);

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarServidor();
            }
        });

        detenerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detenerServidor();
            }
        });

    }

    public void reponseErrorClient(Socket client) {
        try {
            OutputStream outputStream = client.getOutputStream();
            //outputStream.write(0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeBoolean(false);
        } catch (IOException e) {
            addErrorLog("No se pudo enviar la respuesta al cliente", e);
        }
    }

    public void reponseSuccessClient(Socket client) {
        try {
            OutputStream outputStream = client.getOutputStream();
            outputStream.write(1);
            //ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            //objectOutputStream.writeBoolean(true);
        } catch (IOException e) {
            addErrorLog("No se pudo enviar la respuesta al cliente", e);
        }
    }

    public void addLog(String message) {
        String text = String.format("%s\n[%s] %s", textArea1.getText(), new Date(), message);
        textArea1.setText(text);
    }

    public void addErrorLog(String error, Exception e) {
        addLog(String.format("ERROR: %s | ", error, e.getMessage()));
    }

    public void detenerServidor() {
        int port = server.getLocalPort();
        addLog(String.format("Deteniendo al servidor en el puerto %d...", port));
        try {
            server.close();
            addLog(String.format("Servidor detenido del puerto %d", port));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error al detener el servidor", JOptionPane.ERROR_MESSAGE);
            addLog(String.format("ERROR: No se puede detener el servidor en el puerto %d", port));
            return;
        }
        isStarted = false;
        detenerButton.setEnabled(false);
        labelConectado.setText("DESCONECTADO");
        // ...
        threadServer = null;
        iniciarButton.setEnabled(true);
    }

    public void iniciarServidor() {
        int port = (int) spinner1.getValue();
        addLog(String.format("Iniciando el servidor en el puerto %d...", port));
        try {
            server = new ServerSocket(port);
            port = server.getLocalPort();
            addLog(String.format("Servidor iniciado en el puerto %d", port));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error al iniciar el servidor", JOptionPane.ERROR_MESSAGE);
            addLog(String.format("ERROR: No se puede iniciar el servidor en el puerto %d", port));
            return;
        }
        iniciarButton.setEnabled(false);
        detenerButton.setEnabled(true);
        labelConectado.setText("CONECTADO");
        threadServer = new Thread() {
            @Override
            public void run() {
                while (isStarted) {
                    Socket client;

                    try {
                        client = server.accept();
                    } catch (IOException e) {
                        //addErrorLog("No se pudo aceptar el cliente", e);
                        continue;
                    }

                    TransferFile transferFile = null;

                    try {
                        InputStream inputStream = client.getInputStream();
                        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                        transferFile = (TransferFile) objectInputStream.readObject();
                    } catch (IOException e) {
                        addErrorLog("No se recibir el archivo desde el cliente", e);
                    } catch (ClassNotFoundException e) {
                        addErrorLog("La clase del archivo transferido no coincide", e);
                    }

                    if (transferFile == null) {
                        reponseErrorClient(client);
                    } else {
                        try {
                            String path = String.format("%s/%s.%s", System.getProperty("user.dir"), transferFile.getFilename(), transferFile.getExtension());
                            FileOutputStream fileOutputStream = new FileOutputStream(path);
                            fileOutputStream.write(transferFile.getData());
                            fileOutputStream.close();

                            addLog(String.format("Archivo guardado: %s", path));
                            reponseSuccessClient(client);
                        } catch (IOException e) {
                            addErrorLog("No se pudo almacenar el archivo", e);
                            reponseErrorClient(client);
                        }
                    }

                    try {
                        client.close();
                    } catch (IOException e) {
                        addErrorLog("No se pudo desconectar al cliente", e);
                    }
                }
            }
        };
        threadServer.start();
        isStarted = true;
    }

    private void inicializarVentana() {
        frame = new JFrame();
        frame.add(panel1);
        frame.setSize(800, 400);
        frame.setTitle("Servidor de Archivos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void lanzarVentana() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ServerUI serverUI = new ServerUI();

        serverUI.lanzarVentana();
    }

}
