package entities;

public class Hormiga {

    private int x;
    private int y;
    private DireccionHomiga orientacion;

    public Hormiga() { // new Hormiga()
        x = 0;
        y = 0;
        orientacion = DireccionHomiga.NORTE;
    }

    public Hormiga(int x, int y) { // new Hormiga(x, y)
        this.x = x;
        this.y = y;
        orientacion = DireccionHomiga.NORTE;
    }

    public Hormiga(int x, int y, DireccionHomiga orientacion) { // new Hormiga(x, y, DireccionHormiga.SUR)
        this.x = x;
        this.y = y;
        this.orientacion = orientacion;
    }

    public void mirarNorte() {
        orientacion = DireccionHomiga.NORTE;
    }

    public void moverNorte() {
        mirarNorte();
        mover();
    }

    public void mirarSur() {
        orientacion = DireccionHomiga.SUR;
    }

    public void moverSur() {
        mirarSur();
        mover();
    }

    public void mirarEste() {
        orientacion = DireccionHomiga.ESTE;
    }

    public void moverEste() {
        mirarEste();
        mover();
    }

    public void mirarOeste() {
        orientacion = DireccionHomiga.OESTE;
    }

    public void moverOeste() {
        mirarOeste();
        mover();
    }

    public void mover() {
        /*switch (orientacion) {
            case NORTE:
                y++;
                break;
            case SUR:
                y--;
                break;
            case ESTE:
                x++;
                break;
            case OESTE:
                x--;
                break;
            default:
                System.out.println("La orientación no es válida");
                break;
        }*/

        switch (orientacion) {
            case NORTE -> y++;
            case ESTE -> x++;
            case SUR -> y--;
            case OESTE -> x--;
            default -> System.out.println("La orientación no es válida");
        }
    }

    public void mover(int pasos) {
        //for (int i = 1; i <= pasos; i++) {
        //    mover();
        //}

        while (pasos-- > 0) {
            mover();
        }
    }

    @Override
    public String toString() {
        return String.format("Hormiga(x: %4d, y: %4d) [%-5s] @%x", x, y, orientacion, this.hashCode());
    }
}
