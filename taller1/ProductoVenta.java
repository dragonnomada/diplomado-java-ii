package taller1;

public class ProductoVenta {

    Producto producto;
    int cantidad;
    double precioUnitario;
    double precioTotal;

    public ProductoVenta(Producto producto, int cantidad, double precioUnitario, double precioTotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
}
