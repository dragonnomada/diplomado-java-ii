package entities;

import java.util.Date;

public class Venta {

    // 1. Atributos
    private int id;
    private Date fechaInicio;
    private Date fechaTermino;    // null
    private double importe;
    private double montoPagado;   // 0.0
    private double montoDevuelto; // 0.0

    // 2. Constructor
    public Venta(int id, double importe) {
        this.id = id;
        this.importe = importe;
        fechaInicio = new Date();
    }

    // 3. Métodos

    // 3.1 Getters
    public int getId() {
        return id;
    }

    // Cuándo los atributos son objetos, al devolverlos podrían quedar expuestos
    // Es decir, que alguien podría modificar el objeto desde afuera
    public Date getFechaInicio() {
        return (Date) fechaInicio.clone();
    }

    // Algunos objetos podrían no estar inicializados o ser nulos
    // Debemos considerar que podrían ser nulos, por lo que no podríamos usarlos
    // para extraer un clone o cosas del estilo
    public Date getFechaTermino() {
        if (fechaTermino == null) {
            return null;
        }
        return (Date) fechaTermino.clone();
    }

    // Al devolver booleanos como getters
    // lo más común es usar el prefijo `is` o `has` en lugar de `get`
    public boolean isFinalizado() {
        return fechaTermino != null;
    }

    public boolean isPagado() {
        return (long)(importe * 100) == (long)((montoPagado - montoDevuelto) * 100);
    }

    public double getImporte() {
        return importe;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public double getMontoDevuelto() {
        return montoDevuelto;
    }

    // 3.2 Setters
    protected void setImporte(double importe) {
        if (importe > 0) {
            this.importe = importe;
        }
    }

    public void setMontoPagado(double montoPagado) {
        if (!isFinalizado()) {
            this.montoPagado = montoPagado;
            montoDevuelto = montoPagado - importe;
            if (montoDevuelto < 0) {
                montoDevuelto = 0;
            }
        } else {
            System.out.printf("La venta <%3d> ya finalizó, no se puede cambiar el monto\n", id);
        }
    }

    // 3.3 Métodos adicionales
    public boolean cerrarVenta() {
        if (isPagado()) {
            fechaTermino = new Date();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Venta <%3d> [%s]: I $%8.2f (P $%8.2f / D $%8.2f) [%s]",
                id, fechaInicio, importe, montoPagado, montoDevuelto, fechaTermino);
    }

}
