# TALLER 201

## Mostrar un diálogo con mensaje al pulsar un botón

### 1. Crear una ventana

```java
import javax.swing.*;

class T201_App {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        
        // TODO: Configura la ventana con
        //          - Título
        //          - Tamaño de 400x400
        //          - EXIT_ON_CLOSE
        //          - Visible

    }

}
```

### 2. Definir un botón y agregarlo a la ventana

```java
import javax.swing.*;

class T201_App {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        
        JButton button = new JButton("Mostrar diálogo");
        
        // TODO: Define el ActionListener informal
        //          PISTA: button.addActionListener(...);
        
        // ...

    }

}
```

### 3. Muestra un `JOptionPane` sobre el botón

```java
import javax.swing.*;

class T201_App {

    public static void main(String[] args) {

        // ...
        JOptionPane.showMessageDialog(button, "Hola mundo");
        // ...

    }

}
```
