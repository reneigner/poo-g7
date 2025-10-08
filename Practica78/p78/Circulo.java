import java.awt.Dimension;
import java.awt.Graphics2D;

public class Circulo {
    

    @Override 

    @Override 

    @Override
    public void dibujar(Graphics2D g, Dimension size) {
        double margen = 20;
        double maxDiametroPanel = Math.min(size.width, size.height) - 2 * margen;
        double diametroFigura = 2 * Math.max(getRadio(), 1.0);
        double escala = maxDiametroPanel / diametroFigura;

        int d = (int) Math.round(2 * getRadio() * escala);
        int x = (size.width - d) / 2;
        int y = (size.height - d) / 2;
        g.drawOval(x, y, d, d);
    }
}