package t02_conceptos;

// import javax.swing.JFrame;
// import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

// JFrame - Construir una venta
// JPanel - Construir una región visual (contenedor de elementos)
// JComponent - Clase abstracta que define lo común a todos los componentes
// JButton - Construir un botón
// JLabel - Construir una etiqueta de texto
// JTextField - Construir una caja de texto para ingresar texto desde el usuario
// ...

public class T201_TestAppSimple {

    public static void main(String[] args) {

        // 1. Instanciar -> Geneneramos el objeto/referencia (componente)
        JFrame frame1 = new JFrame(); // -> ventana 1 (500x500)
        JFrame frame2 = new JFrame(); // -> ventana 2 (800x400)
        JFrame frame3 = new JFrame(); // -> ventana 3 (100x100)

        // 2. Configurar -> Inicializar los valores y conexiones entre componentes
        frame1.setSize(500, 500);
        frame2.setSize(800, 400);
        frame3.setSize(100, 100);

        frame1.setLocation(710, 290);
        frame2.setLocationRelativeTo(frame1);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar -> Finaliza la aplicación
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar -> Libera los recursos de la venta
        frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Cerrar -> Quitar la visibilidad de la venta

        frame1.setTitle("Ventana 1");
        frame2.setTitle("Ventana 2");
        frame3.setTitle("Ventana 3 - Hola mundo");

        frame1.setVisible(true);
        frame2.setVisible(true);

        // PANELES

        // 1. Instanciar componente
        JPanel panel1 = new JPanel(); // Panel -> Norte
        JPanel panel2 = new JPanel(); // Panel -> Sur
        JPanel panel3 = new JPanel(); // Panel -> Oeste
        JPanel panel4 = new JPanel(); // Panel -> Este
        JPanel panel5 = new JPanel(); // Panel -> Centro

        // 2. Configurar el componente
        panel1.setBackground(new Color(214, 242, 165));
        panel2.setBackground(new Color(172, 242, 209));
        panel3.setBackground(new Color(159, 228, 245));
        panel4.setBackground(new Color(201, 169, 245));
        panel5.setBackground(new Color(255, 171, 200));

        panel5.setLayout(new BorderLayout()); // Ajustamos el layout del panel

        /**
         * BORDER LAYOUT
         *
         * Al diseñar una aplicación, esta por defecto tiene un layout de tipo BorderLayout,
         * el cuál divide las regiones en 5 posibles:
         *
         * Norte - Arriba
         * Sur - Abajo
         * Oeste - Izquierda
         * Este - Derecha
         * Centro - Centro
         *
         * El BorderLayout puede ser aplicado directamente sobre el JFrame
         * mediante el método <frame>.add(<component>, BorderLayout.<DIRECTION>).
         *
         * Los paneles siguen la misma lógica, por lo que podríamos orientar
         * componentes dentro de un panel en las 5 posibilidades.
         *
         * Por ejemplo: Un label arriba, un botón a la izquierda, otro botón a la derecha,
         * un textField abajo y un panel al centro.
         *
         * El elemento central siempre se estirará lo más posible y los otros
         * serán colapsados lo más posible. Esto significa, que si un botón queda al centro
         * crecerá lo más que pueda.
         *
         */

        // 3. Enlazar/combinar/añadir/anidar/componer componentes
        frame2.add(panel1, BorderLayout.NORTH);
        frame2.add(panel2, BorderLayout.SOUTH);
        frame2.add(panel3, BorderLayout.WEST);
        frame2.add(panel4, BorderLayout.EAST);
        frame2.add(panel5, BorderLayout.CENTER);

        // 1. Instanciar un componente Botón
        JButton button1 = new JButton("Pulsame");

        // 2. Configuarar el componente Botón
        button1.setText("Hola mundo");

        // 3. Añadir el botón al panel5
        panel5.add(button1, BorderLayout.WEST);

    }


}
