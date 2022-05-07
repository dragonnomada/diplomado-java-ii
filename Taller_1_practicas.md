# Taller 1 - Practicas

## Objetivos

El Taller 1 consiste en construir una Tienda de Productos en Línea de Comandos.

1. Generar Menús Relacionados a Operaciones
2. Determinar cada operación como un método
3. Importar datos de archivos
4. Exportar datos a archivos
5. Dominar el modelado de entidades
6. Dominar el uso de Arreglos
7. Separar en componentes
8. Reportar un log de operaciones
9. Compilar un JAR
10. Publicar y distribuir la aplicación

## 1. Menús y Operaciones

```text

TiendaCL
-----------------------------------
1. Administrador de Productos
2. Administrador de Venta
3. Salir

AdministradorProductosCL
-----------------------------------
1. Consultar Producto
2. Ver Productos
3. Agregar Producto
4. Modificar Producto
5. Quitar Producto
6. Importar Productos
7. Exportar Productos
8. Regresar

AdministradorVentaCL
-----------------------------------
1. Consultar Venta
2. Consultar Producto
3. Agregar Producto a Venta
4. Quitar Producto de Venta
5. Completar Venta
6. Cancelar Venta
7. Regresar

```

## 2. Prototipado de los Componentes

El objetivo de prototipar los componentes es detectar las operaciones de cada componente
y establecer un método que realice cada operación.

Las operaciones generalmente dependerán de más operaciones internas que iremos agregando al prototipo.

Antes de escribir código es importante imaginar y modelar las operaciones y tareas que hará el componente
y establecer si hace falta alguna entidad para poder transferir datos entre las operaciones.

> TiendaCL

```java
class TiendaCL {
    
    void mostrarMenu() {}
    
    void abrirAdministradorProductos() {}
    
    void abrirAdministradorVenta() {}
    
    void salir() {}
    
}
```

> AdministradorProductosCL

```java
class AdministradorProductosCL {
    
    void mostrarMenu() {}
    
    void consultarProducto() {}
    
    void verProductos() {}
    
    void agregarProducto() {}

    void modificarProducto() {}

    void quitarProducto() {}
    
    void importarProductos() {}
    
    void exportarProductos() {}
    
    void regresar() {}
    
}
```

> AdministradorVentaCL

```java
class AdministradorVentaCL {
    
    void mostrarMenu() {}
    
    void consultarVenta() {}
    
    void consultarProducto() {}
    
    void agregarProductoVenta() {}
    
    void quitarProductoVenta() {}
    
    void completarVenta() {}
    
    void cancelarVenta() {}
    
    void regresar() {}
    
}
```

## 3. Extender las operaciones de los prototipos

> TiendaCL

```java
import java.util.Scanner;

class TiendaCL {

    void mostrarMenu() {}

    int solicitarOpcion(Scanner scanner) {}
    
    void seleccionarOpcion(int opcion) {}

    void abrirAdministradorProductos() {}

    void abrirAdministradorVenta() {}

    void salir() {}

}
```

> AdministradorProductosCL

```java
import java.util.Scanner;

class AdministradorProductosCL {

    void mostrarMenu() {}

    int solicitarOpcion(Scanner scanner) {}

    void seleccionarOpcion(int opcion) {}
    
    void consultarProducto() {}
    
    String solicitarCodigoBarras(Scanner scanner) {}
    
    Producto buscarProductoConCodigoBarras(String codigoBarras) {}
    
    void mostrarProducto(Producto producto) {}

    void verProductos() {}
    
    ArrayList<Producto> obtenerProductos() {}
    
    void mostrarProductos(ArrayList<Producto> productos) {}

    void agregarProducto() {}
    
    String solicitarNombre(Scanner scanner) {}
    
    double solicitarPrecio(Scanner scanner) {}
    
    int existencias(Scanner scanner) {}
    
    Producto crearProducto(String codigoBarras, String nombre, double precio, int existencias) {}
    
    void agregarProducto(Producto producto) {}

    void modificarProducto() {}
    
    boolean preguntarModificarNombre(Scanner scanner) {}
    
    void modificarProductoNombre(Producto producto, String nombre) {}
    
    boolean preguntarModificarPrecio(Scanner scanner) {}

    void modificarProductoPrecio(Producto producto, double precio) {}

    boolean preguntarModificarExistencias(Scanner scanner) {}
    
    boolean autorizarSupervisor(Scanner scanner) {}

    void modificarProductoExistencias(Producto producto, int existencias) {}

    void quitarProducto() {}

    void importarProductos() {}
    
    String solicitarArchivo(Scanner scanner) {}
    
    void leerProductos(String archivo) {}
    
    Producto leerSiguienteProducto(Scanner scanner) {}
    
    boolean haySiguienteProducto(Scanner scanner) {}

    void exportarProductos() {}
    
    String describirProducto() {}
    
    String descibirProductos() {}
    
    void escribirProductos(String archivo) {}

    void regresar() {}

}
```

> AdministradorVentaCL

```java
import java.util.Scanner;

class AdministradorVentaCL {
    
    void mostrarMenu() {}

    int solicitarOpcion(Scanner scanner) {}

    void seleccionarOpcion(int opcion) {}
    
    void consultarVenta() {}
    
    ArrayList<ProductoVenta> obtenerProductosVenta() {}
    
    void mostrarProductosVenta(ArrayList<ProductoVenta> productosVenta) {}
    
    void mostrarProductoVenta(ProductoVenta productoVenta) {}
    
    double calcularTotal(ArrayList<ProductoVenta> productosVenta) {}
    
    void consultarProducto() {}
    
    void agregarProductoVenta() {}
    
    int solicitarCantidad(Scanner scanner) {}
    
    double obtenerPrecioUnitario(Producto producto) {}
    
    double obtenerPrecioTotal(Producto producto, int cantidad) {}
    
    ProductVenta crearProductoVenta(Producto producto, int cantidad, double precioUnitario, double precioTotal) {}
    
    void agregarProductoVenta(ProductoVenta productoVenta) {}
    
    void quitarProductoVenta() {}

    boolean autorizarSupervisor(Scanner scanner) {}
    
    ProductoVenta buscarProductoVenta(String codigoBarras) {}

    void quitarProductoVenta(ProductoVenta productoVenta) {}
    
    void completarVenta() {}
    
    double solicitarImporte(Scanner scanner) {}
    
    String solicitarPago(Scanner scanner, ArrayList<ProductoVenta> productosVenta, double total) {}
    
    void imprimirTicket(ArrayList<ProductoVenta> productosVenta, double total, String pago) {}
    
    void cancelarVenta() {}
    
    void regresar() {}
    
}
```





















