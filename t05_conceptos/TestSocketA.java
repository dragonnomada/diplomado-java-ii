import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TestSocketA {

    public static void main(String[] args) {

        Thread threadServer = new Thread() {
            @Override
            public void run() {
                ServerSocket serverSocket;

                try {
                    serverSocket = new ServerSocket(4444);
                } catch (IOException e) {
                    System.out.println("No se pudo crear un servidor socket en el puerto 4444");
                    System.out.println(e.getMessage());
                    return;
                }

                String tablero = "";

                while (true) {
                    System.out.printf("Esperando clientes en el puerto %d\n", serverSocket.getLocalPort());

                    Socket cliente;

                    // Aceptamos/Recuperamos al siguiente cliente (despachar al cliente)
                    try {
                        cliente = serverSocket.accept();
                        System.out.printf("Cliente conectado: %s\n", cliente.getRemoteSocketAddress());
                    } catch (IOException e) {
                        System.out.println("No pude aceptar al cliente");
                        System.out.println(e.getMessage());
                        continue;
                    }

                    try {
                        // TODO: Recibir y enviar datos al cliente (peteción del cliente)
                        InputStream inputStream = cliente.getInputStream();
                        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                        PaqueteInput paqueteInput = (PaqueteInput) objectInputStream.readObject();
                        Date fecha = new Date();
                        String registro = String.format("[%s] %s (%d): %s", fecha,
                                paqueteInput.getUsername(), paqueteInput.getUserId(),
                                paqueteInput.getMessage()
                        );
                        System.out.println(registro);
                        tablero += registro + "\n";
                        //objectInputStream.close();

                        // TODO: Procesar el paquete de entrada y formar un paquete de salida (responder al cliente)
                        PaqueteOutput paqueteOutput = new PaqueteOutput(fecha, registro, tablero);
                        OutputStream outputStream = cliente.getOutputStream();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                        objectOutputStream.writeObject(paqueteOutput);
                        //objectOutputStream.close();
                    } catch (Exception e) {
                        System.out.println("Error al procesar la petición o responderle al cliente");
                        System.out.println(e.getMessage());
                    }

                    // Cerramos el socket del cliente :D
                    try {
                        cliente.close();
                    } catch (IOException e) {
                        System.out.printf("Error al cerrar el cliente");
                    }
                }

            }
        };

        threadServer.start();

    }

}
