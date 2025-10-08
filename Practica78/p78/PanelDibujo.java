package mx.unam.fi.poo.p78;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PanelDibujo extends JPanel {
    private Figura figura;

    public PanelDibujo() {
        setPreferredSize(new Dimension(380, 300));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }

    public void setFigura(Figura f) {
        this.figura = f;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics gRaw) {
        super.paintComponent(gRaw);
        if (figura == null) return;
        Graphics2D g = (Graphics2D) gRaw;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        figura.dibujar(g, getSize());
    }
}