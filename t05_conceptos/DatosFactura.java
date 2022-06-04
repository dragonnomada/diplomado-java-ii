import java.io.Serializable;

public class DatosFactura implements Serializable {

    private String rfcOrigen;
    private String rfcDestino;
    private double importe;
    private double impuestosTranslados;
    private double impuestosRetenidos;

    public DatosFactura(String rfcOrigen, String rfcDestino, double importe, double impuestosTranslados, double impuestosRetenidos) {
        this.rfcOrigen = rfcOrigen;
        this.rfcDestino = rfcDestino;
        this.importe = importe;
        this.impuestosTranslados = impuestosTranslados;
        this.impuestosRetenidos = impuestosRetenidos;
    }

    public String getRfcOrigen() {
        return rfcOrigen;
    }

    public String getRfcDestino() {
        return rfcDestino;
    }

    public double getImporte() {
        return importe;
    }

    public double getImpuestosTranslados() {
        return impuestosTranslados;
    }

    public double getImpuestosRetenidos() {
        return impuestosRetenidos;
    }

    @Override
    public String toString() {
        return "DatosFactura{" +
                ", rfcOrigen='" + rfcOrigen + '\'' +
                ", rfcDestino='" + rfcDestino + '\'' +
                ", importe=" + importe +
                ", impuestosTranslados=" + impuestosTranslados +
                ", impuestosRetenidos=" + impuestosRetenidos +
                '}';
    }
}
