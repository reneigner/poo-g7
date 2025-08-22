import java.util.Hashtable;

public class Ejemplo2 {
    public static void main(String[] args) {
        Hashtable<String, Integer> miTabla = new Hashtable<String, Integer>();
        miTabla.put("uno", 1);
        miTabla.put("dos", 2);
        miTabla.put("diez", 10);

        System.out.println("¿Contiene a cuatro?" + miTabla.containsKey("cuatro"));

        for (String clave : miTabla.keySet()) {
            System.out.println(clave);
        }

        for (Integer valor : miTabla.values()) {
            System.out.println(valor);
        }
    }
}
