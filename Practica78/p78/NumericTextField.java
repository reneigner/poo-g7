package mx.unam.fi.poo.p78;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumericTextField extends JTextField {

    public NumericTextField(int columns) {
        super(columns);
        addKeyListener(new KeyAdapter() {
            @Override public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && c != '\b') {
                    e.consume();
                }
            }
        });
    }

    public static double safeParse(String s) {
        if (s == null) return 0.0;
        String t = s.trim();
        if (t.matches("\\d+(\\.\\d+)?")) {
            return Double.parseDouble(t);
        }
        return 0.0;
    }
}