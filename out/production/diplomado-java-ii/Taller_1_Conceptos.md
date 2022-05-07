# Taller 1 - Conceptos

Taller 1 - Aplicaciones de Consola

## Agenda

1. Delegados e Interfaces
2. Componentes
3. Manejo de Errores
4. Manejo de Archivos

## 1. Delegados e Interfaces

El delegamiento de código consiste en establecer un protocolo que nos permita delegar, es decir,
promoveer la resposabilidad de implementar el código en otros lados del proyecto.

Las interfaces proveen un mecanismo de determinar funciones abstractas/virtuales,
las cuales no tienen implementación y son las clases las responsables de implementarlas.

Mediante las interfaces podemos crear protocolos y delegar código.

> Ejemplo: Interfaz `ITodoList` posee operaciones para agregar y completar los TODOs

```java
interface ITodoList {

    boolean agregarTodo(String titulo);

    void completarTodo(int indice);
    
    void incompletarTodo(int indice);
    
    String mostrarTodos();
    
}
```

> Ejemplo: Clase `TodoListSimple` implementa la interfaz `ITodoList` de forma simple

```java
import java.util.ArrayList;

class Todo {
    String titulo;
    boolean completado;
    
    Todo(String titulo) {
        this.titulo = titulo;
        this.completado = false;
    }
}

class TodoListSimple implements ITodoList {

    ArrayList<Todo> todos = new ArrayList<>();

    boolean agregarTodo(String titulo) {
        todos.add(new Todo(titulo));
    }

    void completarTodo(int indice) {
        Todo todo = todos.get(indice);
        
        todo.completado = true;
    }

    void incompletarTodo(int indice) {
        Todo todo = todos.get(indice);

        todo.completado = false;
    }

    String mostrarTodos() {
        String text = "";
        
        for (Todo todo : todos) {
            text += String.format("[%B] %s\n", todo.completado, todo.titulo);
        }
        
        return text;
    }

}
```

## 2. Componentes

Los componentes se conforman de interfaces requeridas e interfaces ofrecidas.

Una interfaz requerida es aquella que tiene como objetivo ajustar datos al componentes
estableciendo métodos dirigidos al ajuste de datos. Por ejemplo:
`setTitulo`, `setPrecio`, `setActivo`, `setCliente`, ..., `<setter>`.

Una interfaz ofrecida es aquella que tiene como objetivo extraer datos del componente
estableciendo métodos dirigidos a la extracción de datos. Por ejemplo: 
`getTitulo`, `getPrecio`, `calcularTotal`, `getPago`, `isPagado`, ..., `<getter>`.

Los componentes sirven para ensamblar procesos a través de transacciones entre lo que
se ofrece y lo que se requiere. Así, si un componente nos ofrece un cliente, por ejemplo,
`capturadorCliente.getCliente()` y otro componente requiere un cliente, por ejemplo,
`ventaACliente.setCliente(cliente)`. Entonces podemos crear un ensamble o composición
también conocido como transacción: `ventaACliente.setCliente(capurtadorCliente.getCliente())`.

Esto nos permitirá crear ensambles entre componentes, sin limitarnos de unos a otros
(crearemos sistemas no-restringidos conocidos como sistemas abiertos). Por ejemplo,
podemos hacer una venta a cliente a partir de un cliente obtenido de un correo:
`ventaACliente.setCliente(administradorCorreo.buscarCliente("pepe@gmail.com").getCliente())`.

> Ejemplo: Interfaz Requerida `IDatosProducto` para ajustar los datos de un producto

```java
interface IDatosProducto {
    
    void setNombre(String nombre);
    
    void setPrecio(double precio);
    
    void setExistencias(int existencias);
    
}
```

> Ejemplo: Interfaz Requerida `IVenta` para ajustar los datos de una venta

```java
interface IVenta {

    void setListaProductos(IListaProductos listaProductos);
    
    void setCliente(ICliente cliente);
    
    void setVendedor(IVendedor vendedor);
    
    void setPago(IPago pago);

}
```

> Ejemplo: Interfaz Ofrecida `IListaProductos` para extraer los datos de una lista de productos

```java
interface IListaProductos {
    
    int getTotalProductos();
    
    IProducto getProductoByIndex(int i);
    
    IProducto getProductoById(int id);
    
    IProducto[] getProductos();
    
    double getPrecioTotal();
    
}
```

> Ejemplo: Interfaz Ofrecida `ICliente `para extraer los datos de un cliente

```java
interface ICliente {
    
    int getId();
    
    String getNombre();
    
    String getCorreo();
    
    String direccion1();
    
    String direccion2();

    String telefono();
    
}
```

## 3. Manejo de Errores

Los errores en Java se pueden PROPAGAR o se pueden CONTROLAR.

PROPAGAR un error significa hacer que nuestra función produzca/arroje el mismo error
que está siendo generado en su código. Esto sirve para advertir a siguientes programadores
que al usar nuestro método se podrían generar errores (los mismos que sean propagados).

CONTROLAR un error significa hacer que nuestra función maneje los posibles errores mediante
`try-catcb` para evitar la propagación de dichos errores y establecer el mecanismo para resolverlos.

> Ejemplo: Propagar el error al capturar un entero

```java
import java.util.Scanner;

class CaptudadorProducto {

    int capturarExistencias(Scanner scanner) throws Exception {
        System.out.print("Dame las existencias: ");
        int existencias = scanner.nextInt();
        scanner.nextLine();
        return; existencias;
    }

}
```

> Ejemplo: Controlar el error al capturar un entero

```java
import java.util.Scanner;

class CaptudadorProducto {

    int capturarExistencias(Scanner scanner) {
        System.out.print("Dame las existencias: ");
        int existencias;
        try {
            existencias = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("No se pudo capturar las existencias");
            return capturarExistencias(scanner); // RECURSIVIDAD
        }
        scanner.nextLine();
        return existencias;
    }

}
```







