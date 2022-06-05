package servidor_cliente_archivos;

import java.io.Serializable;

public class TransferFile implements Serializable {

    private String filename;
    private String extension;
    private byte[] data;

    public TransferFile(String filename, String extension, byte[] data) {
        this.filename = filename;
        this.extension = extension;
        this.data = data;
    }

    public String getFilename() {
        return filename;
    }

    public String getExtension() {
        return extension;
    }

    public byte[] getData() {
        return data;
    }

    @Override
    public String toString() {
        return "TransferFile{" +
                "filename='" + filename + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
