import java.io.Serializable;
import java.util.Date;

public class PaqueteOutput implements Serializable {

    private Date fecha;
    private String registro;
    private String tablero;

    public PaqueteOutput(Date fecha, String registro, String tablero) {
        this.fecha = fecha;
        this.registro = registro;
        this.tablero = tablero;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getRegistro() {
        return registro;
    }

    public String getTablero() {
        return tablero;
    }

    @Override
    public String toString() {
        return "PaqueteOutput{" +
                "fecha=" + fecha +
                ", registro='" + registro + '\'' +
                ", tablero='" + tablero + '\'' +
                '}';
    }
}
