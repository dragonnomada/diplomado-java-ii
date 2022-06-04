import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TestServerFacturacion {

    public static void main(String[] args) {

        Thread threadServer = new Thread() {
            @Override
            public void run() {
                ServerSocket serverSocket;

                try {
                    serverSocket = new ServerSocket(5555);
                } catch (IOException e) {
                    System.out.println("No se pudo crear un servidor socket en el puerto 5555");
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

                        // TODO: Procesar la entrada para producir una salida
                        DatosFactura datosFactura = (DatosFactura) objectInputStream.readObject();
                        System.out.println(datosFactura);
                        // ...
                        String uuid = "123456-78910";
                        String cadenaDigital = "abc123qrdsedfgfxxx";
                        String qr = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAALoAAAC6CAIAAACWbMCmAAAD20lEQVR" +
                                "4nO3dwU7kOBRA0aY1///LzG42YeHrsR0XOmfZaqoKuLJ4cuJ8fX9//4Exf9/+AHwSuRDIhUAuBHIh+Of5" +
                                "T19fX+c/x39GJrWRTzg38c298qqf2L5XnvP8PFYXArkQyIVALgRyIfhhMnrat6808pf/qjlo1ZQx9zqrp" +
                                "p53fxdWFwK5EMiFQC4EciEYmoyePvGv+rnZ5OTe05yTvwurC4FcCORCIBcCuRBMTkYnze0HjcxBq/ZxRl" +
                                "75d7C6EMiFQC4EciGQC8EHTEYjbrtD5+l3TE9WFwK5EMiFQC4EciGYnIw+8a/6p5O7SHPvPuLk78LqQiAX" +
                                "ArkQyIVALgRDk9G7+y/7rpS77f+MePd3YXUhkAuBXAjkQiAXgq/fsfvzdPJcgpPnLbzL6kIgFwK5EMiFQC" +
                                "4EG/eM9p0FN7Ijs+oc730T1sk7j1b95K0uBHIhkAuBXAjkQjC5Z3T/jszc3PHuk15X2XcFoNWFQC4EciGQ" +
                                "C4FcCH6YjN59Fs+qGWfkvVY5OZeteve5T2h1IZALgVwI5EIgF4Khq+n2XeU18sr7ZoqR99o3T737dFp7Rm" +
                                "wnFwK5EMiFQC4Ek/cZ7dsl2XfN24i57/TkaXXv7pdZXQjkQiAXArkQyIVgcs9o1fN63j2xbdUJDKu+i1Wz0" +
                                "r6vsroQyIVALgRyIZALweR9Rk+3nXe97+S3k/crjTg5PVldCORCIBcCuRDIhWDZfUYn56mRd9+3k/KJ5z+M" +
                                "fNUIqwuBXAjkQiAXArkQ/DAZzU0H+05I2/fuq+ybnt49EcKeEf+LXAjkQiAXArkQDF1N94nnLbx7TeDJn4Y" +
                                "9Iy4lFwK5EMiFQC4EQ096ffdJprc9LWjklW+7p2nV57G6EMiFQC4EciGQC8EPV9Pdv0ez79q5fVevndzrGTl" +
                                "XfO6VrS4EciGQC4FcCORCMHk13dBLH9xpuv9psCfvGJpjMmIxuRDIhUAuBHIhGLqa7l23PUd13+s4tZtfRS4" +
                                "EciGQC4FcCJY9z2iV+6eDVZ9n5L1umwqtLgRyIZALgVwI5EKw7HlGc0b+Yp/bW5n7PyN36Jw8EWLVT37V/Gt" +
                                "1IZALgVwI5EIgF4KhyejpE89bWDVh3X8SnVO7uYJcCORCIBcCuRBMTkYnzc0Lc7tRI959pu3TqisJXU3HYnIh" +
                                "kAuBXAjkQvABk9HTqqvpbrNqT23uq0ZmJasLgVwI5EIgFwK5EExORu/OHbedEbHqqryRr3qyZ8Sl5EIgFwK5E" +
                                "MiFYGgyum0SeTp5msG79t3lNMLqQiAXArkQyIVALgQf8Dwj7mF1IZALgVwI5EIgF4J/AQn0O3phg04fAAAAA" +
                                "ElFTkSuQmCC";
                        Factura factura = new Factura(uuid, new Date(), new Date(), cadenaDigital, qr);


                        // TODO: Procesar el paquete de entrada y formar un paquete de salida (responder al cliente)
                        OutputStream outputStream = cliente.getOutputStream();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                        objectOutputStream.writeObject(factura);
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
