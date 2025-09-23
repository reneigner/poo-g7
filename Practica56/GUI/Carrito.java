import java.util.ArrayList;
import java.util.List;

public class Carrito {
    List<Articulo> articulos;

    public Carrito() {
        this.articulos = new ArrayList<>(); //Polimorismo
    }

    public boolean agregar(Articulo a) {
        if (a == null) return false;
        if (a.nombre.isEmpty()) return false;
        articulos.add(a);
        return true;
    }

    public boolean eliminarPorIndice(int index) {
        if (index < 0) return false;
        if (index >= articulos.size()) return false;
        articulos.remove(index);
        return true;
    }

    public boolean eliminarPorNombre(String nombre) {
        if (nombre == null) return false;
        String target = nombre.trim();
        if (target.isEmpty()) return false;
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).nombre.equalsIgnoreCase(target)) {
                articulos.remove(i);
                return true;
            }
        }
        return false;
    }

    public void limpiar() {
        articulos.clear();
    }

    public List<Articulo> getArticulos() {
        return new ArrayList<>(articulos);
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < articulos.size(); i++) {
            total += articulos.get(i).precio;
        }
        return total;
    }
}