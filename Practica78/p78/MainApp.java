package mx.unam.fi.poo.p78;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MainApp {

    private JFrame frame;
    private JComboBox<String> comboFiguras;
    private JLabel l1, l2;
    private NumericTextField t1, t2;
    private JLabel areaLbl, perLbl;
    private PanelDibujo panelDibujo;

    private static final String FIG_CIRCULO = "Círculo";
    private static final String FIG_RECTANGULO = "Rectángulo";
    private static final String FIG_TRIANGULO = "Triángulo rectángulo";

    private void crearGUI() {
        frame = new JFrame("Práctica 7 y 8");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Figura:"));
        comboFiguras = new JComboBox<>(new String[]{FIG_CIRCULO, FIG_RECTANGULO, FIG_TRIANGULO});
        top.add(comboFiguras);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.gridx = 0; c.gridy = 0; c.anchor = GridBagConstraints.LINE_END;

        l1 = new JLabel("Radio:");
        l2 = new JLabel("—");
        t1 = new NumericTextField(10);
        t2 = new NumericTextField(10);
        t2.setEnabled(false);

        form.add(l1, c);
        c.gridx = 1; c.anchor = GridBagConstraints.LINE_START;
        form.add(t1, c);

        c.gridx = 0; c.gridy = 1; c.anchor = GridBagConstraints.LINE_END;
        form.add(l2, c);
        c.gridx = 1; c.anchor = GridBagConstraints.LINE_START;
        form.add(t2, c);

        JButton calcular = new JButton("Calcular y Dibujar");
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2; c.anchor = GridBagConstraints.CENTER;
        form.add(calcular, c);

        c.gridy = 3; c.gridwidth = 1; c.anchor = GridBagConstraints.LINE_END;
        form.add(new JLabel("Área:"), c);
        c.gridx = 1; c.anchor = GridBagConstraints.LINE_START;
        areaLbl = new JLabel("0.0");
        form.add(areaLbl, c);

        c.gridx = 0; c.gridy = 4; c.anchor = GridBagConstraints.LINE_END;
        form.add(new JLabel("Perímetro:"), c);
        c.gridx = 1; c.anchor = GridBagConstraints.LINE_START;
        perLbl = new JLabel("0.0");
        form.add(perLbl, c);

        panelDibujo = new PanelDibujo();

        JPanel center = new JPanel(new BorderLayout(8, 8));
        center.add(form, BorderLayout.WEST);
        center.add(panelDibujo, BorderLayout.CENTER);
        center.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        comboFiguras.addActionListener(e -> actualizarFormulario());
        calcular.addActionListener(e -> calcularYDibujar());

        frame.getContentPane().add(top, BorderLayout.NORTH);
        frame.getContentPane().add(center, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        actualizarFormulario();
    }

    private void actualizarFormulario() {
        String sel = Objects.toString(comboFiguras.getSelectedItem(), FIG_CIRCULO);
        if (FIG_CIRCULO.equals(sel)) {
            l1.setText("Radio:");
            l2.setText("—");
            t1.setText("");
            t2.setText("");
            t2.setEnabled(false);
        } else if (FIG_RECTANGULO.equals(sel)) {
            l1.setText("Ancho:");
            l2.setText("Alto:");
            t1.setText("");
            t2.setText("");
            t2.setEnabled(true);
        } else {
            l1.setText("Base:");
            l2.setText("Altura:");
            t1.setText("");
            t2.setText("");
            t2.setEnabled(true);
        }
        areaLbl.setText("0.0");
        perLbl.setText("0.0");
        panelDibujo.setFigura(null);
    }

    private void calcularYDibujar() {
        String sel = Objects.toString(comboFiguras.getSelectedItem(), FIG_CIRCULO);

        double p1 = NumericTextField.safeParse(t1.getText());
        double p2 = NumericTextField.safeParse(t2.getText());

        if (p1 <= 0) p1 = 1.0;
        if (t2.isEnabled() && p2 <= 0) p2 = 1.0;

        Figura f;
        if (FIG_CIRCULO.equals(sel)) {
            f = new Circulo(p1);
        } else if (FIG_RECTANGULO.equals(sel)) {
            f = new Rectangulo(p1, p2);
        } else {
            f = new TrianguloRectangulo(p1, p2);
        }

        areaLbl.setText(String.format("%.4f", f.area()));
        perLbl.setText(String.format("%.4f", f.perimetro()));
        panelDibujo.setFigura(f);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().crearGUI());
    }
}