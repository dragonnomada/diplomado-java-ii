import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Producto {

    int id;
    String nombre;
    String descipcion;
    double precio;
    int existencias;
    boolean activo;

    public Producto(String nombre, String descipcion, double precio, int existencias, boolean activo) {
        this.nombre = nombre;
        this.descipcion = descipcion;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public boolean isActivo() {
        return activo;
    }
}

public class T204_App {
    private JTextField textFieldNombre;
    private JTextArea textAreaDescipcion;
    private JTextField textFieldPrecio;
    private JSlider sliderExistencias;
    private JCheckBox activoCheckBox;
    private JButton crearButton;

    public T204_App() {

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = textFieldNombre.getText();
                String descripcion = textAreaDescipcion.getText();
                double precio;
                try {
                    precio = Double.parseDouble(textFieldPrecio.getText());
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(crearButton, "Error");
                    return;
                }
                int existencias = sliderExistencias.getValue();
                boolean estaActivo = activoCheckBox.isSelected();

                Producto producto = new Producto(nombre, descripcion, precio, existencias, estaActivo);

                System.out.println(producto);

                // TODO: Guardar el producto en la base de datos

                // TODO: [Opcional] Reiniciar el formulario

            }
        });

    }
}
