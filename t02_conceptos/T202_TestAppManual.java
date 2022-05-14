package t02_conceptos;

import javax.swing.*;
import java.awt.*;

public class T202_TestAppManual {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JPanel panelIzquierda = new JPanel();
        JPanel panelCentro = new JPanel();
        JPanel panelDerecha = new JPanel();

        panelIzquierda.setLayout(new BorderLayout());

        JLabel labelTituloIzq = new JLabel("Menú");
        JLabel labelFooterIzq = new JLabel("Selecciona una opción");

        JButton button1Izq = new JButton("1. Opción A");
        JButton button2Izq = new JButton("2. Opción B");
        JButton button3Izq = new JButton("3. Opción C");
        JButton button4Izq = new JButton("4. Opción D");

        JPanel panelOpcionesIzquierda = new JPanel();

        panelOpcionesIzquierda.setLayout(new BoxLayout(panelOpcionesIzquierda, BoxLayout.Y_AXIS));

        panelOpcionesIzquierda.add(button1Izq);
        panelOpcionesIzquierda.add(button2Izq);
        panelOpcionesIzquierda.add(button3Izq);
        panelOpcionesIzquierda.add(button4Izq);

        panelIzquierda.add(labelTituloIzq, BorderLayout.NORTH);
        panelIzquierda.add(panelOpcionesIzquierda, BorderLayout.CENTER);
        panelIzquierda.add(labelFooterIzq, BorderLayout.SOUTH);

        frame.add(panelIzquierda, BorderLayout.WEST);

        // PANEL CENTRO
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));

        JLabel labelTituloCentro = new JLabel("Iniciar Sesión");
        JTextField textFieldUsuarioCentro = new JTextField();
        JTextField textFieldContraseñaCentro = new JTextField();
        JButton buttonAceptarCentro = new JButton("aceptar");

        panelCentro.add(labelTituloCentro);
        panelCentro.add(textFieldUsuarioCentro);
        panelCentro.add(textFieldContraseñaCentro);
        panelCentro.add(buttonAceptarCentro);

        frame.add(panelCentro, BorderLayout.CENTER);

        // Configuración del JFrame

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
