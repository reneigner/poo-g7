public class Punto {
    int x = 0, y = 0;
    
    public Punto() {}

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Punto (x = " + x + ", y = " + y + ")";
    }
}