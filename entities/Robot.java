package entities;

// 0. CLASE
public class Robot {

    // 1. ATRIBUTOS
    int x; // defecto: 0
    int y; // defecto: 0

    // 2. CONSTRUCTORES
    public Robot() { // new Robot()
        x = 0;
        y = 0;
    }

    public Robot(int x, int y) { // new Robot(x, y)
        this.x = x; // this.x -> atributo de la clase | x -> parámetro del constructor
        this.y = y; // ambigüedad de variables (y / y) -> (this.y / y) | colisión de variables
    }

    // 3. MÉTODOS
    @Override
    public String toString() {
        return String.format("Robot(x: %d, y: %d) @%x", x, y, this.hashCode());
    }

}
