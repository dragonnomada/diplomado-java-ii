import java.io.Serializable;
import java.util.Date;

public class Factura implements Serializable {

    private String uuid;
    private Date creado;
    private Date trimbado;
    private String cadenaDigital;
    private String qr;

    public Factura(String uuid, Date creado, Date trimbado, String cadenaDigital, String qr) {
        this.uuid = uuid;
        this.creado = creado;
        this.trimbado = trimbado;
        this.cadenaDigital = cadenaDigital;
        this.qr = qr;
    }

    public String getUuid() {
        return uuid;
    }

    public Date getCreado() {
        return creado;
    }

    public Date getTrimbado() {
        return trimbado;
    }

    public String getCadenaDigital() {
        return cadenaDigital;
    }

    public String getQr() {
        return qr;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "uuid='" + uuid + '\'' +
                ", creado=" + creado +
                ", trimbado=" + trimbado +
                ", cadenaDigital='" + cadenaDigital + '\'' +
                ", qr='" + qr + '\'' +
                '}';
    }
}
