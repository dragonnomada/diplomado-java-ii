# TALLER 203

## Crear un bloc de notas simple

### 1. Diseñar una aplicación que tenga un `JTextArea` y un `JButton`

    Nota: Alinea el `JTextArea` arriba abarcando casi toda la pantalla
    y el botón abajo centrado que diga guardar.

### 2. En el `ActionListener` del `JButton` guardar recupera el texto

    guardarButton.addActionListener(new ActionListener() {
    
        @Override
        public void actionPerformed(...) {
            String contenido = textArea1.getText();

            // TODO: Guardar el contenido en un archivo

            System.out.println(contenido);
        }

    });

### 3. Crea un `JFileChooser` para seleccionar un archivo

    JFileChooser fileChooser = new JFileChooser();

    int result = fileChooser.showOpenDialog(guardarButton);

    if (result == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();

        // TODO: Escribe el contenido en el archivo
    } else {
        JOptionPane.showMessageDialog(...<error>...)
    }

### 4. Escribir el contenido del `JTextArea` en el archivo

    FileWriter writer = new FileWriter(file);

    writer.write(contenido);

    writer.close()

    // TODO: 1. Mostrar un dialogó que se guardó
                - JOptionPane.showMessageDialog(...)
    // TODO: 2. Resetar el texto del JTextArea
                - textArea1.setText("")
    // TODO: 3. Cerrar el frame
                - frame.dispose()