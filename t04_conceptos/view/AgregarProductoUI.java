package view;

import controller.AgregarProductosController;
import model.ProductosDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class AgregarProductoUI implements IAgregarProductoView {
    private JTextField textField1;
    private JTextArea textArea1;
    private JTextField textField2;
    private JSpinner spinner1;
    private JButton agregarButton;
    private JPanel panel1;

    private JFrame frame;

    private AgregarProductosController controller;
    private ProductosDB model;

    public AgregarProductoUI() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        model = new ProductosDB();

        controller = new AgregarProductosController();
        controller.setModel(model);
        controller.setView(this);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.transactionAgregarProducto();
            }
        });

        frame = new JFrame();

        frame.add(panel1);
        frame.setTitle("Agregar producto");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public String getNombre() {
        return textField1.getText();
    }

    @Override
    public String getDescripcion() {
        return textArea1.getText();
    }

    @Override
    public double getPrecio() {
        try {
            return Double.parseDouble(textField2.getText());
        } catch (Exception ex) {
            return -1;
        }
    }

    @Override
    public int getExistencias() {
        return (int)spinner1.getValue();
    }

    @Override
    public void reinciarVista() {
        textField1.setText("");
        textArea1.setText("");
        textField2.setText("");
        spinner1.setValue(0);
        textField1.requestFocus();
    }

    @Override
    public void mostrarAgregarProductoCorrecto() {
        JOptionPane.showMessageDialog(frame, "Se agregó el producto correctamente", "Producto agregado", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarAgregarProductoError(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje, "Error al agregar el producto", JOptionPane.ERROR_MESSAGE);
    }
}
