# TALLER 204

## Captura de un Producto

### 1. Establece la clase `Producto` con `getters` y el contructor completo

    Producto
    ------------------------------------------
    id: int
    nombre: String
    descripcion: String
    precio: double
    existencias: int
    activo: boolean

> Agrega el método `toString()` que describa el producto
    
### 2. Diseña una aplicación de swing con los elementos necesarios para capturar un producto

    App
    =========================================
    nombre -> JTextField
    descripcion -> JTextArea
    precio -> JTextField
    existencias -> JSlider (min: 0, max: 100)
    activo -> JCheckbox
    crear -> JButton

### 3. En el `ActionListen` del `JButton` crear, recupera los valores

    String nombre = textFieldNombre.getText()
    String descripcion = textArea.getText()
    double precio;
    try {
        precio = Double.parseDouble(textFieldPrecio.getText())
    } catch(Exception ex) {
        JOptionPane.showMessageDialog(...<error>...);
        return;
    }
    int existencias = sliderExistencias.getValue();
    boolean estaActivo = checkboxActivo.isSelected;
    ...
    Producto producto = new Producto(nombre, descripcion, precio, ...);

    System.out.println(producto);

    // TODO: Guardar el producto en la base de datos 

    // TODO: [Opcional] Reiniciar el formulario