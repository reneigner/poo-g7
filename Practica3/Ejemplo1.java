import java.util.ArrayList;

public class Ejemplo1 {
    public static void main(String[] args) {
        ArrayList<Integer> arreglo = new ArrayList<Integer>();
        arreglo.add(1);
        arreglo.add(8);
        arreglo.add(10);
        arreglo.add(0, 9);
        System.out.println("Tamaño del arreglo dinámico " + arreglo.size());
        System.out.println("Elemento en la posición 3: " + arreglo.get(3));
        for (Integer elemento : arreglo) {
            System.out.println(elemento);
        }
    }
}