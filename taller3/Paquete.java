import java.sql.Timestamp;

public class Paquete {

    private int id;
    private String sku;
    private String guia; // mod
    private boolean activo; // mod
    private Timestamp createAt;
    private Timestamp updateAt; // mod

    public Paquete(int id, String sku, String guia, boolean activo, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.sku = sku;
        this.guia = guia;
        this.activo = activo;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getGuia() {
        return guia;
    }

    public boolean isActivo() {
        return activo;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
}
