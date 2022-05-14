# TALLER 202

## Calcular el cuadrado de un número

### 1. Diseñar una aplicación que tenga un `JTextField` y un `JButton`

    * Puedes usar el editor visual de Swing Forms

### 2. Agrega un `ActionListener` en el botón para calcular el cuadrado del valor del `JTextField`

    Nota: En el constructor o en algún lugar accesible

    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPermormed(...) {
            String texto = textField1.getText();

            double valor = Double.parseDouble(texto);

            double valor2 = valor * valor;

            String mensaje = String.format("El cuadrado es: %f", valor2);

            System.out.println(mensaje);

            JOptionPane.showMessageDialog(button1, mensaje);
        }
    });

### 3. Controla el posible error de conversión, por ejemplo, si el usuario no pone un número

    try {
        valor = Double.parseDouble(texto);
    } catch(Exception e) {
        JOptionPane.showMessageDialog(textField1, 
            "Error al convertir el valor", 
            "No es un número decimal", 
            JOptionPane.ERROR_MESSAGE);
    }