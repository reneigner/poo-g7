import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Vista extends JFrame{
    // Componentes encapsulados
    private final JTextField nombreField;
    private final JTextField precioField;
    private final JButton agregarButton;
    private final JButton eliminarSelButton;
    private final JButton eliminarPorNombreButton;
    private final JButton limpiarButton;
    private final DefaultListModel<String> listModel;
    private final JList<String> lista;
    private final JLabel estadoLabel;
    private final JLabel totalLabel;

    public Vista(String titulo) {
        super(titulo);// Esto es de herencia

        nombreField = new JTextField();
        precioField = new JTextField();
        agregarButton = new JButton("Agregar");
        eliminarSelButton = new JButton("Eliminar seleccionado");
        eliminarPorNombreButton = new JButton("Eliminar por nombre");
        limpiarButton = new JButton("Limpiar carrito");
        listModel = new DefaultListModel<>();
        lista = new JList<>(listModel);
        estadoLabel = new JLabel("Listo.");
        totalLabel = new JLabel("Total: $0.00");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(640, 420));
        setLayout(new BorderLayout(10, 10));

        JPanel entrada = new JPanel(new GridLayout(2, 2, 8, 8));
        entrada.setBorder(BorderFactory.createTitledBorder("Datos del artículo"));
        entrada.add(new JLabel("Nombre:"));
        entrada.add(nombreField);
        entrada.add(new JLabel("Precio:"));
        entrada.add(precioField);

        JPanel acciones = new JPanel(new GridLayout(1, 4, 8, 8));
        acciones.add(agregarButton);
        acciones.add(eliminarSelButton);
        acciones.add(eliminarPorNombreButton);
        acciones.add(limpiarButton);

        JPanel top = new JPanel(new BorderLayout(8, 8));
        top.add(entrada, BorderLayout.CENTER);
        top.add(acciones, BorderLayout.SOUTH);

        JPanel centro = new JPanel(new BorderLayout());
        centro.setBorder(BorderFactory.createTitledBorder("Carrito"));
        JScrollPane scroll = new JScrollPane(lista);
        centro.add(scroll, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(8, 8));
        bottom.add(estadoLabel, BorderLayout.CENTER);
        bottom.add(totalLabel, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    // Getters para que la lógica de la app manipule la UI sin exponer campos
    public JTextField getNombreField() { return nombreField; }
    public JTextField getPrecioField() { return precioField; }
    public JButton getAgregarButton() { return agregarButton; }
    public JButton getEliminarSelButton() { return eliminarSelButton; }
    public JButton getEliminarPorNombreButton() { return eliminarPorNombreButton; }
    public JButton getLimpiarButton() { return limpiarButton; }
    public DefaultListModel<String> getListModel() { return listModel; }
    public JList<String> getLista() { return lista; }
    public JLabel getEstadoLabel() { return estadoLabel; }
    public JLabel getTotalLabel() { return totalLabel; }
}
