import java.awt.Dimension;
import java.awt.Graphics2D;

public abstract class Figura {
    public abstract double area();
    public abstract double perimetro();
    public abstract void dibujar(Graphics2D g, Dimension size);
}