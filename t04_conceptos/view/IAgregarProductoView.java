package view;

public interface IAgregarProductoView {

    String getNombre();
    String getDescripcion();
    double getPrecio();
    int getExistencias();

    void reinciarVista();

    void mostrarAgregarProductoCorrecto();
    void mostrarAgregarProductoError(String mensaje);

}
