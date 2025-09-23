import java.util.List;

import javax.swing.SwingUtilities;

public class MainApp {

    public static void main(String[] args) {
        // Sin excepciones; SwingUtilities no requiere try/catch
        SwingUtilities.invokeLater(() -> {
            Carrito carrito = new Carrito();
            Vista view = new Vista("Carrito de Compras");

            // Listeners
            view.getAgregarButton().addActionListener(e -> {
                String nombre = view.getNombreField().getText();
                double precio = safeParsePrecio(view.getPrecioField().getText());

                if (nombre == null) nombre = "";
                nombre = nombre.trim();

                if (!isNombreValido(nombre)) {
                    view.getEstadoLabel().setText("Nombre inválido (requiere al menos 1 carácter no vacío).");
                    return;
                }
                if (precio < 0) {
                    view.getEstadoLabel().setText("Precio inválido (usa dígitos y punto decimal).");
                    return;
                }

                Articulo a = new Articulo(nombre, precio);
                boolean ok = carrito.agregar(a);
                if (ok) {
                    refrescarLista(view, carrito);
                    limpiarCampos(view);
                    view.getEstadoLabel().setText("Artículo agregado.");
                } else {
                    view.getEstadoLabel().setText("No se pudo agregar el artículo.");
                }
            });

            view.getEliminarSelButton().addActionListener(e -> {
                int idx = view.getLista().getSelectedIndex();
                boolean ok = carrito.eliminarPorIndice(idx);
                if (ok) {
                    refrescarLista(view, carrito);
                    view.getEstadoLabel().setText("Artículo eliminado.");
                } else {
                    view.getEstadoLabel().setText("Selecciona un artículo para eliminar.");
                }
            });

            view.getEliminarPorNombreButton().addActionListener(e -> {
                String nombre = view.getNombreField().getText();
                if (nombre == null) nombre = "";
                boolean ok = carrito.eliminarPorNombre(nombre);
                if (ok) {
                    refrescarLista(view, carrito);
                    view.getEstadoLabel().setText("Artículo eliminado por nombre.");
                } else {
                    view.getEstadoLabel().setText("No se encontró el nombre especificado.");
                }
            });

            view.getLimpiarButton().addActionListener(e -> {
                carrito.limpiar();
                refrescarLista(view, carrito);
                view.getEstadoLabel().setText("Carrito vacío.");
            });

            // Mostrar ventana
            refrescarLista(view, carrito);
            view.setVisible(true);
        });
    }

    // --------- Utilidades sin excepciones ---------

    /** Valida que el nombre tenga al menos un carácter no espacio. */
    private static boolean isNombreValido(String nombre) {
        if (nombre == null) return false;
        String n = nombre.trim();
        if (n.length() == 0) return false;
        return true;
    }

    /**
     * Convierte String a double sin lanzar excepciones:
     * - Acepta dígitos y un solo punto decimal.
     * - Si es inválido, regresa -1 como bandera.
     */
    private static double safeParsePrecio(String s) {
        if (s == null) return -1.0;
        String t = s.trim();
        if (t.length() == 0) return -1.0;

        int dots = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            boolean isDigit = (c >= '0' && c <= '9');
            if (c == '.') {
                dots++;
                if (dots > 1) return -1.0;
            } else if (!isDigit) {
                return -1.0;
            }
        }

        // Construcción manual del valor para evitar NumberFormatException
        double result = 0.0;
        double frac = 0.0;
        double divisor = 1.0;
        boolean afterDot = false;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '.') {
                afterDot = true;
            } else {
                int d = c - '0';
                if (!afterDot) {
                    result = result * 10 + d;
                } else {
                    divisor *= 10.0;
                    frac = frac + d / divisor;
                }
            }
        }
        return result + frac;
    }

    /** Actualiza la lista visual y el total. */
    private static void refrescarLista(Vista view, Carrito carrito) {
        view.getListModel().clear();
        List<Articulo> lista = carrito.getArticulos();
        for (int i = 0; i < lista.size(); i++) {
            view.getListModel().addElement(lista.get(i).toItemString());
        }
        double total = carrito.getTotal();
        view.getTotalLabel().setText("Total: " + formatMoney(total));
    }

    /** Limpia los campos de entrada. */
    private static void limpiarCampos(Vista view) {
        view.getNombreField().setText("");
        view.getPrecioField().setText("");
        view.getLista().clearSelection();
    }

    /** Formatea dinero a dos decimales sin excepciones. */
    private static String formatMoney(double amount) {
        long cents = Math.round(amount * 100);
        String entero = String.valueOf(cents / 100);
        int dec = (int)(cents % 100);
        String decStr = dec < 10 ? ("0" + dec) : String.valueOf(dec);
        return "$" + entero + "." + decStr;
    }
}