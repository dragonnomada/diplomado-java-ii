package entities;

import java.util.ArrayList;
import java.util.Arrays;

public class VentaConProductos extends Venta {

    ArrayList<Producto> productos;

    public VentaConProductos(int id) {
        super(id, 0); // Superclase (Venta)

        productos = new ArrayList<>();
    }

    public Producto[] getProductos() {
        Producto[] productosCopia = new Producto[productos.size()];

        int i = 0;
        for (Producto producto : productos) {
            productosCopia[i++] = producto.copy();
        }

        return productosCopia;
    }

    public Producto getProductoById(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public int getCountProductoById(int id) {
        int contador = 0;
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                contador++;
            }
        }
        return contador;
    }

    public Producto getProductoByNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public Producto[] getProductosByPrecio(double precioMin, double precioMax) {
        ArrayList<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : productos) {
            double precio = producto.getPrecio();
            if (precio >= precioMin && precio <= precioMax) {
                productosFiltrados.add(producto);
            }
        }

        if (productosFiltrados.size() == 0) {
            return null;
        }

        Producto[] productosCopia = new Producto[productosFiltrados.size()];

        int i = 0;
        for (Producto producto : productosFiltrados) {
            productosCopia[i++] = producto.copy();
        }

        return productosCopia;
    }

    public boolean hasProductos() {
        return productos.size() > 0;
    }

    public boolean isEmpty() {
        return productos.size() == 0;
    }

    protected void calcularImporte() {
        double importe = 0;
        for (Producto producto : productos) {
            importe += producto.getPrecio();
        }
        setImporte(importe);
    }

    public boolean agregarProducto(Producto producto) {
        if (producto.hasExistencias()) {
            productos.add(producto);
            producto.quitarExistencia();
            calcularImporte();
            return true;
        } else {
            // TODO: Error de existencias vacías
            return false;
        }
    }

    public boolean agregarProducto(Producto producto, int veces) {
        while (veces-- > 0) {
            if (!agregarProducto(producto)) {
                // TODO: Error ya no se pueden agregar más productos
                return false;
            }
        }
        return true;
    }

    public boolean quitarProducto(Producto producto) {
        return quitarProducto(producto.getId());
    }

    public boolean quitarProducto(int id) {
        Producto producto = getProductoById(id);
        if (producto != null) {
            productos.remove(producto);
            producto.aumentarExistencia();
            calcularImporte();
            return true;
        } else {
            return false;
        }
    }

    public boolean quitarProducto(int id, int veces) {
        while (veces-- > 0) {
            if (!quitarProducto(id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean cerrarVenta() {
        if (isEmpty()) {
            return false;
        }

        return super.cerrarVenta(); // Superclase (Venta)
    }

    @Override
    public String toString() {
        StringBuilder reporte = new StringBuilder(super.toString());

        reporte.append("\n");

        ArrayList<Producto> productosBloqueados = new ArrayList<>();

        for (Producto producto : productos) {
            if (productosBloqueados.contains(producto)) {
                continue;
            }
            reporte.append(producto);
            reporte.append(" ");
            reporte.append("x");
            reporte.append(getCountProductoById(producto.getId()));
            reporte.append("\n");
            productosBloqueados.add(producto);
        }
        reporte.append("------------------------");

        return reporte.toString();
    }
}
